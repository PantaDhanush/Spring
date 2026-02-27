package com.example.SecurityPractice.config;

import com.example.SecurityPractice.entity.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class JwtUtil {

    private static final String SECRET =
            "my-super-secret-key-my-super-secret-key";

    private static final long EXPIRATION = 1000 * 60 * 60;

    public String generateToken(Users user) {
        return Jwts.builder()
                .setSubject(String.valueOf(user.getId()))
                .claim("roles", user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }
    public Claims validateToken(String token) {
        return  Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(SECRET.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}