package com.example.was.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
@Slf4j
public class EventListener {

    @Autowired
    private KafkaService kafkaService;

    @KafkaListener(topics = "signal-workflow-topic",groupId = "group-1")
    public void listener(String value){
        log.info("message=received_message_workflow-automation-service value={}",value);
        kafkaService.send("task-assignment-topic","{task-assignment}");
        log.info("message=sent_message_to_ida-adapter value={}",value);
    }


}
