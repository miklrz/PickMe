package ru.pickme.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pickme.backend.model.ChatRoom;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Integer> {
    public ChatRoom findBySenderIdAndRecipientId(int senderId, int recipientId);
}
