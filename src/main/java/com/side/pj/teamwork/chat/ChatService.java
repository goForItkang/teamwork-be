package com.side.pj.teamwork.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatMapper chatMapper;
    public Object getChatRoomList(String company, String username) {
        return chatMapper.selectByCompanyAndUsername(company,username);
    }
}
