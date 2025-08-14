package com.side.pj.teamwork.user;

import com.side.pj.teamwork.user.dto.ReqSignupUser;
import com.side.pj.teamwork.user.dto.ResLoginUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    //로그인한 유저 Query문
    ResLoginUser selectUser(String id);
    void insertUser(ReqSignupUser reqSignupUser);

    Long selectUserLoginId(String loginId);
}
