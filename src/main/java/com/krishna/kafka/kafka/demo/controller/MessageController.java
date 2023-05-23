package com.krishna.kafka.kafka.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.kafka.kafka.demo.service.KafkaService;

@RestController
@RequestMapping(value = "/message")
public class MessageController {
    
    @Autowired
    private KafkaService kafkaService;

    @GetMapping("/send")
    public ResponseEntity<?> producer(@RequestParam String message){
        kafkaService.send(message);
        return ResponseEntity.ok("Msg sent success fully!");
    }
}
