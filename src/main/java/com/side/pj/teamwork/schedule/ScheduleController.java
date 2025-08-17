package com.side.pj.teamwork.schedule;

import com.side.pj.teamwork.config.ApiResponse;
import com.side.pj.teamwork.schedule.dto.ReqScheduleDTO;
import com.side.pj.teamwork.schedule.dto.ReqScheduleDashDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


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
    //스케줄 페이지에 들어갈 내용
    @GetMapping("/api/schedules/dash")
    public ResponseEntity<ApiResponse> getSchedulesDash(
            @RequestParam String company,
            @RequestParam(required = false) String month,
            @RequestParam(required = false) String day
            ) {

        return ResponseEntity.ok(
                ApiResponse.success(scheduleService.getMontAndDay(company,month,day))
        );
    }
    @PostMapping("/api/schedule/add")
    public ResponseEntity<ApiResponse> addSchedule(@RequestBody ReqScheduleDTO reqScheduleDTO) {
        System.out.println("reqScheduleDTO = " + reqScheduleDTO);
        return ResponseEntity.ok(ApiResponse.success(
                scheduleService.addSchedule(reqScheduleDTO)
        ));
    }
}
