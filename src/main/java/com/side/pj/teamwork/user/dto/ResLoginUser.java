package com.side.pj.teamwork.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResLoginUser {
    private Long id;
    private String loginId;
    private String password;
    private String name;
    private int role_id;

}
