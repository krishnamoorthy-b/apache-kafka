package com.krishna.kafka.kafka.demo.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    final String topic = "chat";
    final String groupID = "12345";

    public void send(String msg) throws Exception{
        CompletableFuture<SendResult<String, String>> futureObj = kafkaTemplate.send(topic,groupID,msg);
        futureObj.whenComplete((response, ex) -> {
            if(ex == null){
                System.out.println("Sent message=[ "+msg+" ] with offset=["+response.getRecordMetadata().offset()+"]");
            } else {
                throw new CompletionException(ex);
            } 
        });
        // main thread will wait until complete kafka thread
        try {
            futureObj.join();
        } catch(CompletionException ex) {
            throw new Exception("Unable to send message=["+msg+"] due to : "+ex.getMessage());
        }
    }

    @KafkaListener(topics = topic, groupId = groupID)
    public void listenChat(String msg){
        System.out.println("Message Recieved => "+msg);
    }
}
