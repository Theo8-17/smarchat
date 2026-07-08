package com.smartaps.smartchat.service;

import com.smartaps.smartchat.domain.Message;
import com.smartaps.smartchat.repository.MessageRepository;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message enregistrerMessage(Message message) {
        message.setDateEnvoi(new Date());
        return messageRepository.save(message);
    }
}