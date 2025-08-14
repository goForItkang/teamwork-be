package com.side.pj.teamwork.attendance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResAttendanceDTO {
    private LocalDateTime attendanceStart;
    private LocalDateTime attendanceEnd;

}
