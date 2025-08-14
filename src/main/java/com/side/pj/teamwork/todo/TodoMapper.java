package com.side.pj.teamwork.todo;

import com.side.pj.teamwork.todo.dto.ResDashTodo;
import com.side.pj.teamwork.todo.dto.ResTodo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface TodoMapper {

    List<ResDashTodo> selectByCompanyAndDepartment(Map<String, Object> params);

    List<ResTodo> selectByCompanyAndStatus(Map<String, String> params);

    ResTodo selectByTodoId(Long id);

    void todoStart(Long id);

    void todoConfirm(Long id);
}
