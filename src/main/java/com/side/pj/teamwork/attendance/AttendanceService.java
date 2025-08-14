package com.side.pj.teamwork.attendance;

import com.side.pj.teamwork.attendance.dto.ResAttendanceDTO;
import com.side.pj.teamwork.config.ApiResponse;
import com.side.pj.teamwork.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
@Transactional
public class AttendanceService {
    private final AttendanceMapper attendanceMapper;
    private final UserService userService;
    public ApiResponse gotoAttendance(String id) {
        try {
            Long userId = userService.getUserIdByLoginId(id);
            attendanceMapper.insertAttendance(userId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ApiResponse.success(null);
    }


    public ResAttendanceDTO getAttendance(String id) {
        Long userId = userService.getUserIdByLoginId(id);
        LocalDate today = LocalDate.now(ZoneId.of("Asia/Seoul"));
        LocalDateTime start = today.atStartOfDay();
        LocalDateTime end = start.plusDays(1);

        Map<String,Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("start", start);
        params.put("end", end);
        return attendanceMapper.selectByUserId(params);
    }
    // 퇴근로직
    public Object outWork(String id) {
        Long userId = userService.getUserIdByLoginId(id);

        LocalDate today = LocalDate.now(ZoneId.of("Asia/Seoul"));
        LocalDateTime start = today.atStartOfDay();
        LocalDateTime end = start.plusDays(1);

        Map<String,Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("start", start);
        params.put("end", end);
        try{
            attendanceMapper.updateEnd(params);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ApiResponse.success(null);
    }
}
