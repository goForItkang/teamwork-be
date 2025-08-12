package com.side.pj.teamwork.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

// 접근한 유저
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAccess implements UserDetails {
    private String username; // 식별 번호 (UID,ID)
    private String password;
    private String company;
    private String role; // ROLE_USER,ROLE_ADMIN

    // 접근 권한 넣는 파트

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(()->role);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
