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
    private int id;

    @Column(name="chat_id")
    private int chatId;

    @Column(name="sender_id")
    private int senderId;

    @Column(name = "recipient_id")
    private int recipientId;
}