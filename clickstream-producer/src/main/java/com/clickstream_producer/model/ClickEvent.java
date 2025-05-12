package com.clickstream_producer.model;

import java.time.Instant;

import lombok.Data;

@Data
public class ClickEvent {
    private String userId;
    private String productId;
    private String eventType;
    private String ip;
    private Instant timestamp;
}
