package com.tom.mvc.global.jwt;

import com.tom.mvc.global.config.JwtConfig;
import com.tom.mvc.infrastructure.auth.enums.JwtGrantType;
import com.tom.mvc.infrastructure.auth.enums.JwtUserType;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JwtProvider {

    private final JwtConfig jwtConfig;

    public String generateToken(JwtUserType userType, JwtGrantType grantType, Map<String, String> claims) {
        SecretKey key = Keys.hmacShaKeyFor(getSecretKey(userType, grantType).getBytes());
        long expiration = getExpiration(userType, grantType);

        return Jwts.builder()
                .claim(Claims.ISSUED_AT, new Date())
                .claim(Claims.EXPIRATION, new Date(System.currentTimeMillis() + expiration))
                .claims(claims)
                .signWith(key)
                .compact();
    }

    public Claims getPayload(JwtUserType userType, JwtGrantType grantType, String token) {
        SecretKey key = Keys.hmacShaKeyFor(getSecretKey(userType, grantType).getBytes());

        return Jwts.parser()
                .verifyWith(key) // 서명 키로 검증
                .build()
                .parseSignedClaims(token)
                .getPayload(); // 특정 클레임을 String 타입으로 반환

    }

    public boolean validateToken(JwtUserType userType, JwtGrantType grantType, String token) {
        SecretKey key = Keys.hmacShaKeyFor(getSecretKey(userType, grantType).getBytes());
        try {
            Jwts.parser()
                    .verifyWith(key) // 서명 키로 검증
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    private String getSecretKey(JwtUserType userType, JwtGrantType tokenType) {
        if (JwtUserType.ADMIN.equals(userType)) {
            return JwtGrantType.ACCESS.equals(tokenType) ? jwtConfig.getAdminAccessSecretKey() : jwtConfig.getAdminRefreshSecretKey();
        }
        return JwtGrantType.ACCESS.equals(tokenType) ? jwtConfig.getClientAccessSecretKey() : jwtConfig.getClientRefreshSecretKey();
    }

    // ✅ 역할과 토큰 타입(Access/Refresh)에 따라 만료 시간 반환
    private long getExpiration(JwtUserType userType, JwtGrantType tokenType) {
        if (JwtUserType.ADMIN.equals(userType)) {
            return JwtGrantType.ACCESS.equals(tokenType) ? jwtConfig.getAdminAccessExpiration() : jwtConfig.getAdminRefreshExpiration();
        }
        return JwtGrantType.ACCESS.equals(tokenType) ? jwtConfig.getClientAccessExpiration() : jwtConfig.getClientRefreshExpiration();
    }
}