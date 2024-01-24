package com.example.entity.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users") // 예약어 사용으로 인한 에러, => 테이블명 설정해줌
@Getter
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    private String socialId;

    @OneToMany(mappedBy = "user")
    private List<Bookmark> bookmarkList;

    @OneToMany(mappedBy = "user")
    private List<SingleHistory> singleHistoryList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quizroom_id")
    private Quizroom quizroom;

    private String nickname;
    private int level;
    private int exp;

    // provider
    // refresh token

    private boolean isPlaying;
    private int recentCorrectCount;
    private int maxCorrectCount;
    private String imageUrl;
}
