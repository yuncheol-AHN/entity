package com.example.entity.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
public class SingleHistory {

    @Id @GeneratedValue
    @Column(name = "sigle_history_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private int trialCount;
    private LocalDateTime createDate;
    private boolean isCorrect;
    private String resultText;
}
