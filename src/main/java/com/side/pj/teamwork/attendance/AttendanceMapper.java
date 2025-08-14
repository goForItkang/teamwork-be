package com.side.pj.teamwork.attendance;

import com.side.pj.teamwork.attendance.dto.ResAttendanceDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Mapper
public interface AttendanceMapper {
    void insertAttendance(@Param("userId") Long userId);

    ResAttendanceDTO selectByUserId(Map<String, Object> params);

    void updateEnd(Map<String, Object> params);
}
