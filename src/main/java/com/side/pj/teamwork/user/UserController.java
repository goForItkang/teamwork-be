package com.side.pj.teamwork.user;

import com.side.pj.teamwork.config.ApiResponse;
import com.side.pj.teamwork.user.dto.ReqLoginUser;
import com.side.pj.teamwork.user.dto.ReqSignupUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3003")
public class UserController {
    private final UserService userService;
    // 팀장이 사업 및 팀장이 사원에 아이디 및 정보를 가입 시는거 
    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> userSignup(@RequestBody ReqSignupUser reqSignupUser){
        return ResponseEntity.ok(userService.signup(reqSignupUser));
    }
    //1  값 받아오기 *
    // 로그인 controller
    // 프론트에 token 값 확인
    @PostMapping("/login")
    public ResponseEntity<ApiResponse> userLogin(@RequestBody ReqLoginUser reqLoginUser){
        return ResponseEntity.ok(ApiResponse.success(userService.login(reqLoginUser)));
    }

}
