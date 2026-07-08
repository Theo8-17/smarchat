package com.smartaps.smartchat.repository;

import com.smartaps.smartchat.domain.Session;
import com.smartaps.smartchat.domain.Message;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;
import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findBySessionOrderByDateEnvoiAsc(Session session);
}