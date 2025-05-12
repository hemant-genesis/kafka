package com.etl_service.service;

import java.time.Instant;

import org.springframework.stereotype.Service;

import com.etl_service.model.CleanClickEvent;
import com.etl_service.model.ClickEvent;

@Service
public class DataEnricherService {
    public CleanClickEvent enrich(ClickEvent event) {
        CleanClickEvent enriched = new CleanClickEvent();
        enriched.setUserId(event.getUserId());
        enriched.setProductId(event.getProductId());
        enriched.setEventType(event.getEventType());
        enriched.setIp(event.getIp());
        enriched.setEventTime(event.getTimestamp());
        enriched.setProcessedTime(Instant.now());

        // Dummy enrichment logic
        enriched.setCountry(resolveCountry(event.getIp()));
        enriched.setDevice(resolveDevice(event.getIp()));

        return enriched;
    }

    private String resolveCountry(String ip) {
        return "US"; // Stub
    }

    private String resolveDevice(String ip) {
        return "Mobile"; // Stub
    }
}
