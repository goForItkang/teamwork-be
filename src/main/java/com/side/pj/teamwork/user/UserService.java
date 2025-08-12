package com.side.pj.teamwork.user;

import com.side.pj.teamwork.config.ApiResponse;
import com.side.pj.teamwork.config.SecurityConfig;
import com.side.pj.teamwork.user.dto.ReqLoginUser;
import com.side.pj.teamwork.user.dto.ReqSignupUser;
import com.side.pj.teamwork.user.dto.ResLoginUser;
import com.side.pj.teamwork.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final SecurityConfig securityConfig;
    private final JwtUtil jwtUtil;
    /*
    1. 로그인이 데이터에서 맞는지 확인 *
    2. 맞으면 accessToken 생성 *
    3. apiResponse 로 보내주면 끝!
     */

    public String login(ReqLoginUser reqLoginUser) {
        // user 정보 id 로 만판단
        ResLoginUser resLoginUser = userMapper.selectUser(reqLoginUser.getLoginId());
        if (resLoginUser == null) {
            System.out.println("설마 이게 Null이야 ?");
            //Exception 처리 404 not fount 처리 부분
        } else {
            if (securityConfig.passwordEncoder().matches(reqLoginUser.getPassword(), resLoginUser.getPassword())) {
                // jwt 생성 로직
                String token = jwtUtil.generateToken(resLoginUser);
                ApiResponse.success(token);
                return token;
            } else {
                //Exception 처리
            }

        }
        return null;
    }
    @Transactional
    public ApiResponse signup(ReqSignupUser reqSignupUser) {
        try{
            String passwordEncoded = securityConfig.passwordEncoder().encode(reqSignupUser.getPassword());
            reqSignupUser.setPassword(passwordEncoded);
            userMapper.insertUser(reqSignupUser);
            return ApiResponse.success(null);
        }catch (Exception e){
            e.printStackTrace();
            return ApiResponse.error(400,"회원가입 실패 조금이후 다시 실행해주세요!");
        }
    }


}
