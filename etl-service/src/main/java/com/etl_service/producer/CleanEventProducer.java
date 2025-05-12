package com.etl_service.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.etl_service.model.CleanClickEvent;

@Service
public class CleanEventProducer {

    private static final String TOPIC = "clean-clicks";

    @Autowired
    private KafkaTemplate<String, CleanClickEvent> kafkaTemplate;

    public void send(CleanClickEvent event) {
        kafkaTemplate.send(TOPIC, event);
    }
}