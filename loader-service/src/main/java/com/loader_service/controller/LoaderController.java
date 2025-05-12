package com.loader_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loader_service.entity.CleanClickEventEntity;
import com.loader_service.repository.CleanClickRepository;

@RestController
@RequestMapping("/api/loader")
public class LoaderController {

    private final CleanClickRepository cleanClickRepository;

    public LoaderController(CleanClickRepository cleanClickRepository) {
        this.cleanClickRepository = cleanClickRepository;
    }

    @GetMapping
    public ResponseEntity<List<CleanClickEventEntity>> produceEvent() {
        List<CleanClickEventEntity> clicks = cleanClickRepository.findAll();
        if (clicks.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clicks);
    }
}
