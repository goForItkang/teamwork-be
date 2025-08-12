package com.side.pj.teamwork.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//response 스케출 dto
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResSchedule {
    private Long id;
    private String title;
    private String content;
    private Date startDate;
    private Date endDate;
    private String scheduleStatus;
}
