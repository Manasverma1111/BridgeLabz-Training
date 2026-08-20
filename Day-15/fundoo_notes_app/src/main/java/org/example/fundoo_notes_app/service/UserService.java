package org.example.fundoo_notes_app.service;

import org.example.fundoo_notes_app.entity.Role;
import org.example.fundoo_notes_app.entity.User;
import org.example.fundoo_notes_app.repository.UserRepository;
import org.example.fundoo_notes_app.security.JwtUtil;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    public String register(String email, String password, String name) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Email already registered");
        }

        User user = new User();
        user.setEmail(email);
        user.setPasswordHash(passwordEncoder.encode(password));
        user.setName(name);
        user.setRole(Role.USER);

        User saved = userRepository.save(user);

        return jwtUtil.generateToken(String.valueOf(saved.getUserId()), saved.getEmail(), saved.getRole().name());
    }

    public String login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        if (!passwordEncoder.matches(password, user.getPasswordHash())) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        return jwtUtil.generateToken(String.valueOf(user.getUserId()), user.getEmail(), user.getRole().name());
    }

    // Day 16: Redis Caching - repeated lookups of the same user (e.g. on
    // every note request) are served from cache instead of hitting the DB.
    @Cacheable(value = "users", key = "#userId")
    public User getById(int userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @CacheEvict(value = "users", key = "#userId")
    public void evictUserCache(int userId) {
        // Called whenever a user record changes, so stale data isn't served.
    }
}
