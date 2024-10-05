package ru.pickme.backend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatNotification {
    private String id;
    private String senderId;
    private String senderName;
}
