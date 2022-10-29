package project.comit.shop.domain.auth.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Service
public class GeneralTokenService{

    @Value("${product.jwt-secret-key}")
    private String SECRET_KEY;

    public String generalAccessToken(String email, Long time, String tokenType) {

        Claims claims = Jwts.claims();
        claims.put("email", email);
        claims.put("type", tokenType);

        Date now = new Date();

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + time))
                .signWith(getSignKey(SECRET_KEY), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignKey(String secretKey) {
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
