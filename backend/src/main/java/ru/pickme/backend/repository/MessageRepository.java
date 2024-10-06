package ru.pickme.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pickme.backend.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
}
