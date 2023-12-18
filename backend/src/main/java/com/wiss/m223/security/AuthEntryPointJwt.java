package com.wiss.m223.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Diese Klasse implementiert das AuthenticationEntryPoint-Interface und dient als Einstiegspunkt für die Authentifizierung.
 * Sie wird verwendet, um den Benutzer zu authentifizieren und eine Fehlermeldung zurückzugeben, wenn die Authentifizierung fehlschlägt.
 */
@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {
    private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

    @Override
    public void commence(HttpServletRequest request,
            HttpServletResponse response, AuthenticationException authException)
            throws IOException, jakarta.servlet.ServletException {
        logger.error("Unauthorized error: {}", authException.getMessage());
        try {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
