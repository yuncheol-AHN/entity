package com.example.entity.repository;

import com.example.entity.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findBySocialId(String social_id);
}
