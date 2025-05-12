package com.loader_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loader_service.entity.CleanClickEventEntity;

public interface CleanClickRepository extends JpaRepository<CleanClickEventEntity, Long> {
}