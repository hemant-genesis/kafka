package com.clickstream_producer.controller;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clickstream_producer.model.ClickEvent;
import com.clickstream_producer.service.KafkaProducerService;

@RestController
@RequestMapping("/api/events")
public class ClickEventController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/click")
    public String produceEvent(@RequestBody ClickEvent event) {
        event.setTimestamp(Instant.now());
        kafkaProducerService.sendClickEvent(event);
        return "Event sent to Kafka";
    }
}
