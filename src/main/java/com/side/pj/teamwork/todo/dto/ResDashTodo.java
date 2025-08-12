package com.side.pj.teamwork.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ResDashTodo {
    private Long id;
    private String title;
    private String content;
    private String department; // 부서인데 이게 만약 개인일수도 있음
    private String status; // 상태(done,ing,end)
    private String level; // 중요동
    private String userName;
    private String createTime; // 생성일자
    private String updateTime; // 업데이트 날짜
    private String expiredTime; // 만기 시간

}
