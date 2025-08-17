package com.side.pj.teamwork.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// 메인 화면에 출력 할 유저 정보를 가져옴
public class ResUserInfo {
    private String username;
    private String position;
    private String department;
    // 이후 출석  및 정보를 가져옴1
}
