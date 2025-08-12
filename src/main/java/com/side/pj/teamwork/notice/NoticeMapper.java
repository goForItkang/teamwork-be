package com.side.pj.teamwork.notice;

import com.side.pj.teamwork.notice.dto.ResNotice;
import com.side.pj.teamwork.notice.dto.ResNoticeMainDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface NoticeMapper {

    List<ResNotice> selectByCompanyAndMonth(Map<String, Object> params);

    List<ResNoticeMainDto> noticeGetPage(Map<String, Object> params);

    int selectCount(String company);
}
