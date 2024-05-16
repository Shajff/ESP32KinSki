package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class KafkaController {

    @Autowired
    private final KafkaProducer producer;

    @Autowired
    SimpMessagingTemplate template;

    public KafkaController(final KafkaProducer producer, final SimpMessagingTemplate template) {
        this.producer = producer;
        this.template = template;
    }

    @PostMapping("/publish")
    public String sendMessageToKafkaTopic(@RequestBody MessageDTO message){
        this.producer.sendMessage(message.toString());
        return message.toString();
    }
}
