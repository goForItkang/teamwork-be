package com.side.pj.teamwork.department;

import com.side.pj.teamwork.config.ApiResponse;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/api")
public class DepartmentController {
    private final DepartmentService departmentService;
    @GetMapping("/department")
    public ResponseEntity<ApiResponse> getDepartment(@RequestParam String company) {
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(
                ApiResponse.success(departmentService.getDepartment(id,company))
        );
    }
}
