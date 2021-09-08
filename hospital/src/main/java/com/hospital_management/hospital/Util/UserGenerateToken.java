package com.hospital_management.hospital.Util;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class UserGenerateToken {
    public static String userGenerateToken( String userName, String subject, String password) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder().setSubject(subject)
                .claim("userName", userName)
                .claim("password", password)
                .signWith(SignatureAlgorithm.HS256,"secret").setIssuedAt(now);
        return builder.compact();
    }
}

