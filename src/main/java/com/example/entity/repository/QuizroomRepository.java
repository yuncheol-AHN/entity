package com.example.entity.repository;

import com.example.entity.domain.Quizroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizroomRepository extends JpaRepository<Quizroom, Long> {
}
