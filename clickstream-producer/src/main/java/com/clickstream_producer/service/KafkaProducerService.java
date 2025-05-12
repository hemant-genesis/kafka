package com.clickstream_producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.clickstream_producer.model.ClickEvent;

@Service
public class KafkaProducerService {
    private static final String TOPIC = "raw-clicks";

    @Autowired
    private KafkaTemplate<String, ClickEvent> kafkaTemplate;

    public void sendClickEvent(ClickEvent event) {
        kafkaTemplate.send(TOPIC, event);
    }
}
