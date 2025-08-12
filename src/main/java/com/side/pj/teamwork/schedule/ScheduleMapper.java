package com.side.pj.teamwork.schedule;

import com.side.pj.teamwork.schedule.dto.ResSchedule;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ScheduleMapper {

    List<ResSchedule> selectByCompanyAndMonth(Map<String, Object> params);
}
