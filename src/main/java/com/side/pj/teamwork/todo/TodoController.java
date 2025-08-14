package com.side.pj.teamwork.todo;

import com.side.pj.teamwork.config.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;
    //대쉬 보드 출력 todoList
    @GetMapping("/todo/dash")
    public ResponseEntity<ApiResponse> indexTodo(
            @RequestParam(required = true) String company,
            @RequestParam(required = false) String department
    ){
        System.out.println("이거 받아와짐?");
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(ApiResponse.success(todoService.getTodo(company,department,username)));
    }
    @GetMapping("/todos")
    public ResponseEntity<ApiResponse> todoPage(
            @RequestParam(required = true) String company,
            @RequestParam(required = true) String status
    ){
        System.out.println("todo인덱스페이지 라고 할수있징~company = " + company + ", status = " + status);
        String id = SecurityContextHolder.getContext().getAuthentication().getName(); // 사용자 id ex)test
        return ResponseEntity.ok(
                ApiResponse.success(todoService.getTodos(company,status,id))
        );
    }
    @GetMapping("/todo/{id}")
    public ResponseEntity<ApiResponse> todoDetail(@PathVariable Long id){
        System.out.println("id = " + id);
        return ResponseEntity.ok(
                ApiResponse.success(todoService.getTodoDetails(id))
        );
    }
    //프로젝트 시작
    @PutMapping("/todo/start")
    public ResponseEntity<ApiResponse> startTodo(@RequestParam Long id){
        return ResponseEntity.ok(ApiResponse.success(todoService.todoStart(id)));
    }
    @PutMapping("/todo/confirm")
    public ResponseEntity<ApiResponse> confirmTodo(@RequestParam Long id){
        return ResponseEntity.ok(ApiResponse.success(todoService.todoConfirm(id)));
    }


}
