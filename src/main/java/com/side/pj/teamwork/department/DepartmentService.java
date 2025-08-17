package com.side.pj.teamwork.department;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentMapper departmentMapper;
    //todo 대쉬보드에 에 들어갈 department 작업
    public Object getDepartment(String id, String company) {
       return departmentMapper.selectByUserIdAndCompany(id,company);
    }
}
