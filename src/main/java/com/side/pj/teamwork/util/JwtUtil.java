package com.side.pj.teamwork.util;

import com.side.pj.teamwork.user.dto.ResLoginUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
@Slf4j
public class JwtUtil {
    @Value("${token.secret.key}")
    private String secretKey;

    public SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }
    public String generateToken(ResLoginUser loginUser) {
        return Jwts.builder()
                .setSubject(loginUser.getLoginId())// 주체 설정 (고유값)
                .claim("id", loginUser.getId())
                .claim("name",loginUser.getName())
                .claim("role",loginUser.getRole_id())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(getSecretKey(), SignatureAlgorithm.HS256)
                .compact();

    }
    // 서명키 확인
    public boolean validateSignWith(String token) {
         try{
            Jwts.parser().setSigningKey(getSecretKey()).parseClaimsJws(token);
            return true;
         }catch (Exception e){
             return false;
         }
    }
    //만료 시간체크
    public boolean validateExpire(String token){
        //로직 추가 해야함
        try{
            Claims claims = Jwts.parser().setSigningKey(getSecretKey())
                    .parseClaimsJws(token)
                    .getBody();
            if(!claims.getExpiration().before(new Date())){
                return true;
            }else{
                // accessToken 만료시
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }
    // user 정보
    public String getUserRole(String token){
        try{
            Claims claims = Jwts.parser().setSigningKey(getSecretKey()).parseClaimsJws(token).getBody();
            if(claims.get("role").equals(1)){
                return "ROLE_ADMIN";
            }else{
                return "ROLE_USER";
            }
        }catch (Exception e){
            return null;
        }
    }
    public String getUsernameFromToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(getSecretKey())
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getSubject();
        } catch (Exception e) {
            return null;
        }
    }

}
