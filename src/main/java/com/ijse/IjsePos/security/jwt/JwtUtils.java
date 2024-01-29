package com.ijse.IjsePos.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {
    @Value("${app.secret}")
    private String jwtSecret;
    @Value("${app.jwtExpiration}")
    private int jwtExpiraiton;

    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public  String generateTwtToken(Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+jwtExpiraiton))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateJwtToken(String authToken){
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
            return true;
        }catch (MalformedJwtException e){
            System.err.println("Inavalid token");
        }catch (ExpiredJwtException e){
            System.err.println("Expired token");
        }catch (UnsupportedJwtException e){
            System.err.println("Unsupported token format");
        }catch (IllegalArgumentException e){
            System.err.println("Token blank");
        }
        return false;
    }

    public String getUsernameFromJwtToken(String authToken){
        return Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJwt(authToken).getBody().getSubject();
    }
}
