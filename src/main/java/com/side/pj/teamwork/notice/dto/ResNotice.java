package com.side.pj.teamwork.notice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
/*
   Dashboarddp 공지사항에 DTO
 */
public class ResNotice {
    private Long noticeId;
    private String title;
    private String content;
    private String fileUrl; // 파일 목록
    private Date createAt; // 생성일자
}
