package com.example.entity.repository;

import com.example.entity.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject findBySubjectName(String subjectName);
    boolean existsBySubjectName(String subjectName);
}
