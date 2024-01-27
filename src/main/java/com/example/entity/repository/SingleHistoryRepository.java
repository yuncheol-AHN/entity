package com.example.entity.repository;

import com.example.entity.domain.SingleHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface SingleHistoryRepository extends JpaRepository<SingleHistory, Long> {
    SingleHistory findByCreateDate(LocalDate localDate);
}
