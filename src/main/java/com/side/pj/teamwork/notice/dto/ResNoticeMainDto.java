package com.side.pj.teamwork.notice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// notice에 정보를 notice 인덱스 화면을 출력함
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResNoticeMainDto {
    private Long id;
    private String title;
    private String content;
    private String fileUrl; //파일 정보
    private Date createAt;

}
