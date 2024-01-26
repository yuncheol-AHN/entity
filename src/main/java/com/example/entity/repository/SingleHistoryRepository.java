package com.example.entity.repository;

import com.example.entity.domain.SingleHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingleHistoryRepository extends JpaRepository<SingleHistory, Long> {
}
