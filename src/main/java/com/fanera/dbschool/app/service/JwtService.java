package com.fanera.dbschool.app.service;

import com.fanera.dbschool.app.config.SecurityConfig;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JwtService {

    private final SecurityConfig config;

    public String isHaveBearToken(HttpServletRequest request){
        String auTk = this.findAuthorizationTokenBear(request);
        try {
            String res = auTk.replace("Bearer","").trim();
            return res.isEmpty() ? null : res;
        } catch (RuntimeException ex){
            return  null;
        }
    }

    public Boolean validationToken(String obj){
        try {
            Jwts.parser().verifyWith(config.getSECRET_KEY_CONF()).build().parseSignedClaims(obj);
            return true;
        } catch (JwtException ex){
            return false;
        }
    }

    public String genToken(String sub){
        return Jwts.builder().subject(sub).signWith(config.getSECRET_KEY_CONF()).compact();
    }

    public String parseToken(String tk){
        return Jwts.parser()
                .verifyWith(config.getSECRET_KEY_CONF()).build()
                .parseSignedClaims(tk).getBody().getSubject();
    }

    private String findAuthorizationTokenBear(HttpServletRequest request){
        return request.getHeader("Authorization");
    }

}
