package com.etl_service.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.etl_service.model.CleanClickEvent;
import com.etl_service.model.ClickEvent;
import com.etl_service.producer.CleanEventProducer;
import com.etl_service.service.DataEnricherService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ClickEventConsumer {

    @Autowired
    private DataEnricherService enricher;

    @Autowired
    private CleanEventProducer producer;

    @KafkaListener(topics = "raw-clicks", groupId = "etl-group", containerFactory = "kafkaListenerContainerFactory")
    public void process(ClickEvent event) {

        if (isValid(event)) {
            log.info("message recived:::"+ event);
            CleanClickEvent enriched = enricher.enrich(event);
            producer.send(enriched);
        } else {
            System.out.println("Invalid event: " + event);
        }
    }

    private boolean isValid(ClickEvent event) {
        return event.getUserId() != null && event.getProductId() != null;
    }
}

