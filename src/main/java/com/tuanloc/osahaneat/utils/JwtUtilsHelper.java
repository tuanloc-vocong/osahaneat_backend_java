package com.tuanloc.osahaneat.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtUtilsHelper {
    @Value("${jwt.privateKey}")
    private String privateKey;

    public String generateToken(String data){
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
        String jwt = Jwts.builder().setSubject(data).signWith(key).compact();
        return jwt;
    }

    public boolean verifyToken(String token){
        try {
            SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
            Jwts.parser().verifyWith(key).build().parseSignedClaims(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
