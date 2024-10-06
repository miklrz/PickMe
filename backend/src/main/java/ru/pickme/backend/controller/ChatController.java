package ru.pickme.backend.controller;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import ru.pickme.backend.service.ChatMessageService;
import ru.pickme.backend.service.ChatRoomService;

@Controller
public class ChatController {
    private SimpMessagingTemplate messagingTemplate;
    private ChatMessageService chatMessageService;
    private ChatRoomService chatRoomService;

    public ChatController(SimpMessagingTemplate simpMessagingTemplate,
                          ChatMessageService chatMessageService, ChatRoomService chatRoomService){
        this.messagingTemplate = simpMessagingTemplate;
        this.chatMessageService = chatMessageService;
        this.chatRoomService = chatRoomService;
    }
}
