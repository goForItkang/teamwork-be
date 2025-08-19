package com.side.pj.teamwork.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//채팅 리스트 출력
//user 정보(이름,부서,직급,프로필,마지막 대화)
public class ResChatRoomList {
    private Long id;
    private String username;
    private String department; // 부서
    private String jobPosition; // 이름
    private String LastComment;
    private Long RoomId;
}
