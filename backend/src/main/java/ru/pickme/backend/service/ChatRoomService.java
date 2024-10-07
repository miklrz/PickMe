package ru.pickme.backend.service;

import org.springframework.stereotype.Service;
import ru.pickme.backend.model.ChatRoom;
import ru.pickme.backend.repository.ChatRoomRepository;

@Service
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    public ChatRoomService(ChatRoomRepository chatRoomRepository){
        this.chatRoomRepository = chatRoomRepository;
    }

    public int getChatId(int senderId, int recipientId){
        return chatRoomRepository.findBySenderIdAndRecipientId(senderId, recipientId).getChatId();
    }

}

