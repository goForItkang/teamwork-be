package com.side.pj.teamwork.schedule;

import com.side.pj.teamwork.schedule.dto.ResSchedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleMapper scheduleMapper;
    public List<ResSchedule> SchedulesGetDash(String company, int month) {
        String startDate = LocalDate.of(2025, month, 1).toString(); // 2025-07-01
        // 하.. 맵으로 보내는건 오랜만이다 ㅎㅎ;
        Map<String,Object> params = new HashMap<>();
        params.put("company",company);
        params.put("month",startDate);
        return scheduleMapper.selectByCompanyAndMonth(params);
    }
}
