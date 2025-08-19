package com.side.pj.teamwork.chat;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ChatMapper {
    Object selectByCompanyAndUsername(String company, String username);
}
