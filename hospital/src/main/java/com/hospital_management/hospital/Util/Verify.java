package com.hospital_management.hospital.Util;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class Verify {
    public void verifytoken(String authorization) throws Exception {
        try {
            Jwts.parser().setSigningKey("secret").parseClaimsJws(authorization);
        }
        catch (Exception e){
            throw new Exception();
        }
    }
}
