package org.example.fundoo_notes_app.service;

import org.example.fundoo_notes_app.entity.PasswordResetToken;
import org.example.fundoo_notes_app.entity.User;
import org.example.fundoo_notes_app.repository.PasswordResetTokenRepository;
import org.example.fundoo_notes_app.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Implements the recovery pattern the document sketched conceptually
 * (short-lived single-use token + emailed link + separate verify-and-reset
 * endpoint) but left unbuilt as out of Day 13's scope.
 */
@Service
public class PasswordResetService {

    private static final Logger log = LoggerFactory.getLogger(PasswordResetService.class);

    private final UserRepository userRepository;
    private final PasswordResetTokenRepository tokenRepository;
    private final JavaMailSender mailSender;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Value("${app.reset-token.expiry-minutes}")
    private long expiryMinutes;

    public PasswordResetService(UserRepository userRepository,
                                 PasswordResetTokenRepository tokenRepository,
                                 JavaMailSender mailSender) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
        this.mailSender = mailSender;
    }

    /**
     * Always returns normally, even for an unknown email, so callers cannot
     * use this endpoint to discover which emails are registered.
     */
    public void requestReset(String email) {
        userRepository.findByEmail(email).ifPresent(user -> {
            String rawToken = UUID.randomUUID().toString();
            PasswordResetToken resetToken = new PasswordResetToken(
                    rawToken, user.getUserId(), LocalDateTime.now().plusMinutes(expiryMinutes));
            tokenRepository.save(resetToken);
            sendResetEmail(user, rawToken);
        });
    }

    public void resetPassword(String rawToken, String newPassword) {
        PasswordResetToken resetToken = tokenRepository.findByToken(rawToken)
                .orElseThrow(() -> new IllegalArgumentException("Invalid or expired reset token"));

        if (resetToken.isUsed() || resetToken.isExpired()) {
            throw new IllegalArgumentException("Invalid or expired reset token");
        }

        User user = userRepository.findById(resetToken.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid or expired reset token"));

        user.setPasswordHash(passwordEncoder.encode(newPassword));
        userRepository.save(user);

        resetToken.setUsed(true);
        tokenRepository.save(resetToken);
    }

    private void sendResetEmail(User user, String rawToken) {
        String link = "https://your-frontend.example.com/reset-password?token=" + rawToken;
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(user.getEmail());
            message.setSubject("Fundoo Notes - Password Reset");
            message.setText("Use this link to reset your password (valid for "
                    + expiryMinutes + " minutes): " + link);
            mailSender.send(message);
        } catch (Exception e) {
            // Mail server not configured in this environment - log the link
            // instead of failing the request, so the flow is still testable.
            log.warn("Could not send reset email, link for manual use: {}", link);
        }
    }
}
