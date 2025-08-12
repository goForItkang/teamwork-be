package com.side.pj.teamwork.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
//사용자 페이지에서 자기만 볼수있는데 todoList
//개인 업무
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResTodo {
    private Long id;
    private String title;
    private String content;
    private String level;
    private String status;
    private Date createTime;
    private Date expiredTime;
}
