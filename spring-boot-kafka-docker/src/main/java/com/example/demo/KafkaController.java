package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class KafkaController {

    @Autowired
    private final KafkaProducer producer;

    public KafkaController(final KafkaProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    public String sendMessageToKafkaTopic(@RequestBody String measurements){
        this.producer.sendMessage(measurements);
        return measurements;
    }

}
