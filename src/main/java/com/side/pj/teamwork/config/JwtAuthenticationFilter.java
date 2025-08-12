package com.side.pj.teamwork.config;

import com.side.pj.teamwork.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@RequiredArgsConstructor
@Component
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        System.out.println(header);
        // header에 가져온 정보가 null 이거나, Bearer이 아닌경우
        if(header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        // "Bearer token" 공백기 제거한 토큰값 추출
        String token  = header.split(" ")[1];
        log.error(token);
        //
        try {
            // 3. 서명 검증
            if (!jwtUtil.validateSignWith(token)) {
                throw new RuntimeException("Invalid JWT signature.");
            }

            // 4. 만료 시간 검증
            if (!jwtUtil.validateExpire(token)) {
                throw new RuntimeException("JWT expired.");
            }
            String username = jwtUtil.getUsernameFromToken(token); // 추가 필요
            String role = jwtUtil.getUserRole(token); // 예: "ROLE_ADMIN" or "ROLE_USER"
            log.info("username : {}, role : {}", username, role);
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            username,
                            null,
                            Collections.singletonList(new SimpleGrantedAuthority(role))
                    );

            // ✅ SecurityContext에 인증 객체 저장
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (Exception e) {
            e.printStackTrace();
            // 6. 예외 처리
            //exception 처리
        }
        filterChain.doFilter(request, response);
    }
}
