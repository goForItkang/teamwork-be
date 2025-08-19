package com.side.pj.teamwork.chat;

import com.side.pj.teamwork.config.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;
    @GetMapping("/chat/room/list")
    public ResponseEntity<ApiResponse> chatRoom(@RequestParam("company") String company,@RequestParam(required = false) String username) {
        return ResponseEntity.ok(
                ApiResponse.success(chatService.getChatRoomList(company,username))
        );
    }

}
