package com.side.pj.teamwork.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReqScheduleDashDto {
    private String month;
    private String day;
    private String company;
}
