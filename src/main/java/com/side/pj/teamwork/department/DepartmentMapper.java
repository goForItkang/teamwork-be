package com.side.pj.teamwork.department;

import com.side.pj.teamwork.department.dto.ResDepartmentDash;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DepartmentMapper {

    ResDepartmentDash selectByUserIdAndCompany(String id, String company);
}
