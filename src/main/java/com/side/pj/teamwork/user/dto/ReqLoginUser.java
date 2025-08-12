package com.side.pj.teamwork.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqLoginUser {
    private String loginId;
    private String password;
}
