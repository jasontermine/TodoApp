package com.wiss.m223.security;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * Diese Klasse enthält Hilfsmethoden zum Umgang mit JSON Web Tokens (JWT).
 */
@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
    @Value("${m223.app.jwtSecret}") 
    private String jwtSecret;
    @Value("${m223.app.jwtExpirationMs}") 
    private int jwtExpirationMs;

    /**
     * Generiert einen JWT-Token für den angegebenen Benutzer.
     * 
     * @param authentication Die Authentifizierungsinformationen des Benutzers.
     * @return Der generierte JWT-Token.
     */
    public String generateJwtToken(Authentication authentication) {
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    /**
     * Extrahiert den Benutzernamen aus dem angegebenen JWT-Token.
     * 
     * @param token Der JWT-Token.
     * @return Der Benutzername.
     */
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret)
                .parseClaimsJws(token).getBody().getSubject();
    }

    /**
     * Validiert den angegebenen JWT-Token.
     * 
     * @param authToken Der JWT-Token.
     * @return true, wenn der Token gültig ist, andernfalls false.
     */
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret)
                    .parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Ungültige JWT-Signatur: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Ungültiger JWT-Token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT-Token ist abgelaufen: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT-Token wird nicht unterstützt: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT-Claims-String ist leer: {}", e.getMessage());
        }
        return false;
    }
}