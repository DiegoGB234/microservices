package com.microsvices.users_service.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
@Component
public class JwtUtil {
    private final SecretKey secretKey = Jwts.SIG.HS256.key().build();
    private final long EXPERATION_MS= 1000*60*60;

    public String generateToken(String usernam, String role){
        return Jwts.builder()
                .subject(usernam)
                .claim("role", role)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPERATION_MS))
                .signWith(secretKey)
                .compact();
    } 
    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    public boolean isTokenValid(String token) {
        try {
            getClaims(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
