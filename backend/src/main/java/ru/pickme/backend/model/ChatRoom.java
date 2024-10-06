package ru.pickme.backend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "chatrooms")
public class ChatRoom {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name="chat_id")
    private String chatId;

    @Column(name="sender_id")
    private String senderId;

    @Column(name = "recipient_id")
    private String recipientId;
}