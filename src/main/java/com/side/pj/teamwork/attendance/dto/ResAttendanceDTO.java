package com.side.pj.teamwork.attendance.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResAttendanceDTO {
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalDateTime attendanceStart;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalDateTime attendanceEnd;

}
