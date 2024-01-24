package com.example.entity.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity()
@Table(name = "user_table") // 예약어 사용으로 인한 에러, => 테이블명 설정해줌
@Getter // 윤철이형 화이팅 오늘은 세시까지 달려보자 가보자고 !!!!
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    private String socialId;

//    @OneToMany()
//    @JoinColumn(name = "quizroom_id")
//    private Long quizroom_id;

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
