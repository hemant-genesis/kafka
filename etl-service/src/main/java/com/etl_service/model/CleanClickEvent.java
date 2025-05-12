package com.etl_service.model;

import java.time.Instant;

import lombok.Data;

@Data
public class CleanClickEvent {
    private String userId;
    private String productId;
    private String eventType;
    private String ip;
    private String country;
    private String device;
    private Instant eventTime;
    private Instant processedTime;   
}
