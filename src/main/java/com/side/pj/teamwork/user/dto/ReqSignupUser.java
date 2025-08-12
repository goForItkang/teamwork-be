package com.side.pj.teamwork.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//회원 가입시 사용하는 DTO
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqSignupUser {
    private Long id;
    private String loginId; //아이디
    private String password; //비밀번호
    private String name; // 이름

}
