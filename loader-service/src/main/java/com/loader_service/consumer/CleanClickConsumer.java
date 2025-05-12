package com.loader_service.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.loader_service.entity.CleanClickEventEntity;
import com.loader_service.repository.CleanClickRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CleanClickConsumer {

    @Autowired
    private CleanClickRepository repository;

    @KafkaListener(topics = "clean-clicks", groupId = "loader-group", containerFactory = "kafkaListenerContainerFactory")
    public void consume(CleanClickEventEntity event) {
        log.info("from loader:::: "+ event);
        repository.save(event);
        System.out.println("Saved event to DB: " + event.getUserId() + ", " + event.getProductId());
    }
}
