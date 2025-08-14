package com.side.pj.teamwork.attendance;

import com.side.pj.teamwork.config.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
//출근 관련 로직들 여기서 전부 처리
@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class AttendanceController {
    private final AttendanceService attendanceService;
    // 출근 로직
    // 사용자 정보를 가져와서 출근
    @PostMapping("/gotowork")
    public ResponseEntity<ApiResponse> gotoAttendance(){
        String id = SecurityContextHolder.getContext().getAuthentication().getName();

        return ResponseEntity.ok(ApiResponse.success(attendanceService.gotoAttendance(id)));
    }
    @GetMapping("/gotowork/check")
    public ResponseEntity<ApiResponse> gotoAttendanceCheck(){
      String id = SecurityContextHolder.getContext().getAuthentication().getName();
      return ResponseEntity.ok(ApiResponse.success(attendanceService.getAttendance(id)));
    }
    @PostMapping("/outwork")
    public ResponseEntity<ApiResponse> outAttendance(){
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(ApiResponse.success(attendanceService.outWork(id)));
    }
}
