package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    SimpMessagingTemplate template;

    @KafkaListener(topics = "measurements", groupId = "kinski")
    public void consume(String message){
        template.convertAndSend("/topic/message", message);
    }
}
