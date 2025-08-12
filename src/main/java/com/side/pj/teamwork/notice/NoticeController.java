package com.side.pj.teamwork.notice;

import com.side.pj.teamwork.config.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin("http://localhost:3003")
@RequiredArgsConstructor
@RequestMapping("/api")
public class NoticeController {
    private final NoticeService noticeService;
    // 회사 대시보드에 들어갈 내용
    @GetMapping("/notice")
    public ResponseEntity<ApiResponse> getNotice(@RequestParam String company, @RequestParam int month){
        System.out.println("company = " + company + ", month = " + month);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        String role = authentication.getAuthorities().toString();
        System.out.println("username = " + username + ", role = " + role);
        return ResponseEntity.ok(
                ApiResponse.success(noticeService.noticeGetDash(company,month)));
    }
    @GetMapping("/notices")
    public ResponseEntity<ApiResponse> getNoticeByCompany(
            @RequestParam String company,
            @RequestParam(defaultValue= "1") int page
    ){
        System.out.println("company = " + company + ", page = " + page);
        return ResponseEntity.ok(ApiResponse.success(
                noticeService.noticeIndex(company,page)
        ));
    }
    @GetMapping("/notices/count")
    public ResponseEntity<ApiResponse> getNoticeCountByCompany(
            @RequestParam String company
    ){
        return ResponseEntity.ok(ApiResponse.success(
                noticeService.getCount(company)
        ));
    }

}
