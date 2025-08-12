package com.side.pj.teamwork.todo;

import com.side.pj.teamwork.todo.dto.ResDashTodo;
import com.side.pj.teamwork.todo.dto.ResTodo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoMapper todoMapper;
    //대쉬보드에 뿌려질 데이터
    public List<ResDashTodo> getTodo(String company, String department, String username) {
        Map<String,Object> params = new HashMap<>();
        params.put("company",company);
        params.put("department",department);
        params.put("username",username); // 사용자 id 이제 정보겠지

        return todoMapper.selectByCompanyAndDepartment(params);
    }

    public List<ResTodo> getTodos(String company, String status, String id) {
        Map<String,String> params = new HashMap<>();
        params.put("company",company);
        params.put("status",status);
        params.put("id",id);

        return todoMapper.selectByCompanyAndStatus(params);
    }
}
