package com.side.pj.teamwork.notice;

import com.side.pj.teamwork.notice.dto.ResNotice;
import com.side.pj.teamwork.notice.dto.ResNoticeMainDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeMapper noticeMapper;
    public List<ResNotice> noticeGetDash(String company, int month) {
        String date = LocalDate.of(2025,month,1).toString();
        Map<String,Object> params = new HashMap<>();
        params.put("company",company);
        params.put("date",date);
        return noticeMapper.selectByCompanyAndMonth(params);
    }
    // 공지 사항을 전체로 뽑는 게시글
    public List<ResNoticeMainDto> noticeIndex(String company, int page) {
        Map<String,Object> params = new HashMap<>();
        int offset = (page - 1) * 10;
        params.put("company",company);
        params.put("offset",offset);
        return noticeMapper.noticeGetPage(params);
    }
    // notice 테이블에 count(*) 로직
    public int getCount(String company) {
        return noticeMapper.selectCount(company);
    }
}
