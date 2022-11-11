package com.ttinder.ttinder.repository;

import com.ttinder.ttinder.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByReceiveUserOrderByCreatedAtDesc(Long id);
}
