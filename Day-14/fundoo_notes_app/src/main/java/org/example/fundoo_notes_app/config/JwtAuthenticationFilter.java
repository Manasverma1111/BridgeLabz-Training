package org.example.fundoo_notes_app.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.fundoo_notes_app.security.JwtUtil;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

/**
 * Runs once per request, before the request reaches the Controller.
 * Reads the "Authorization: Bearer <token>" header, validates the JWT with
 * JwtUtil, and - if valid - places an Authentication object into the
 * SecurityContext so downstream code (@PreAuthorize, SecurityContextHolder)
 * knows who the caller is and what role they hold (Day 14: Authorization).
 *
 * This is the piece that makes the SecurityFilterChain's
 * .anyRequest().authenticated() rule actually work for JWT-protected
 * endpoints; without it, every protected request would be rejected because
 * nothing ever populates the SecurityContext.
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);

            if (jwtUtil.isTokenValid(token)) {
                String userId = jwtUtil.extractUserId(token);
                String role = jwtUtil.extractRole(token);

                List<GrantedAuthority> authorities =
                        List.of(new SimpleGrantedAuthority("ROLE_" + role));

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userId, null, authorities);

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            // An invalid/expired token is simply not authenticated; the
            // SecurityFilterChain's anyRequest().authenticated() rule then
            // rejects the request with 401 further down the chain.
        }

        filterChain.doFilter(request, response);
    }
}
