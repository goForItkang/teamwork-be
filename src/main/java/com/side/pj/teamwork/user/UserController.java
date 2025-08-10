package com.side.pj.teamwork.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class userController {
    // 팀장이 사업 및 팀장이 사원에 아이디 및 정보를 가입 시는거 
    @PostMapping("/signup")
    public ResponseEntity<String> userSignup(){
        return ResponseEntity.ok("Signup successful");
    }
    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody String id, String password){
        return null;
    }

}
