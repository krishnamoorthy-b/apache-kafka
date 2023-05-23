package com.krishna.kafka.kafka.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    final String topic = "chat";

    public void send(String msg){
        kafkaTemplate.send(topic,msg);
    }
}
