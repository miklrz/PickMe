package ru.pickme.backend.service;

import org.springframework.stereotype.Service;
import ru.pickme.backend.model.Message;
import ru.pickme.backend.model.MessageStatus;
import ru.pickme.backend.repository.MessageRepository;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public Message save(Message message){
        message.setStatus(MessageStatus.RECEIVED);
        messageRepository.save(message);
        return message;
    }
}
