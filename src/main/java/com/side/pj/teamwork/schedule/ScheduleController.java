package com.side.pj.teamwork.schedule;

import com.side.pj.teamwork.config.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;
    //대쉬 보드에 들어갈 내용
    @GetMapping("/api/schedules")
    public ResponseEntity<ApiResponse> getSchedules(@RequestParam String company, @RequestParam int month) {
        System.out.println("=== 스케줄 요청 수신 ===");
        System.out.println("company = " + company + ", mount = " + month);
        
        return ResponseEntity.ok(
                ApiResponse.success(scheduleService.SchedulesGetDash(company,month)));
    }
}
