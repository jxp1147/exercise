package com.shookmaker.exercise.uitls;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtil {
    private static final String SIGN_Key = "signKey=shookermaker";
    private static final Long EXPIRE_TIME = 43200000L;
    public static String getJwt(Map<String, Object> claims) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SIGN_Key)  // 加密方式 密钥
                .setClaims(claims) //加密内容
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME )) // 有效时间  1h
                .compact();
    }
    public static Claims parseJwt(String jwt) {
        return Jwts.parser()
                .setSigningKey(SIGN_Key)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
