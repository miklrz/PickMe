package ru.pickme.backend.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import ru.pickme.backend.model.Message;
import ru.pickme.backend.service.MessageService;
import ru.pickme.backend.service.ChatRoomService;

@Controller
public class ChatController {
    private SimpMessagingTemplate messagingTemplate;
    private final MessageService messageService;
    private final ChatRoomService chatRoomService;

    public ChatController(SimpMessagingTemplate simpMessagingTemplate,
                          MessageService messageService, ChatRoomService chatRoomService){
        this.messagingTemplate = simpMessagingTemplate;
        this.messageService = messageService;
        this.chatRoomService = chatRoomService;
    }

    @MessageMapping("/chat")
    public void processMessage(@Payload Message message){
        int chatId = chatRoomService.getChatId(message.getSenderId(), message.getRecipientId());
        message.setChatId(chatId);

        Message savedMessage = messageService.save(message);
//        messagingTemplate.convertAndSendToUser(
//                chatMessage.getRecipientId(),"/queue/messages",
//                new ChatNotification(
//                        saved.getId(),
//                        saved.getSenderId(),
//                        saved.getSenderName()));
    }
}
