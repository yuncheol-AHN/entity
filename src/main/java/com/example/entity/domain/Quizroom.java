package com.example.entity.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
public class Quizroom {

    @Id @GeneratedValue
    @Column(name = "quizroom_id")
    private Long id;

    @OneToMany(mappedBy = "quizroom")
    private List<User> userList;

    @OneToMany(mappedBy = "quizroom")
    List<QuizroomWord> quizroomWords;

    @Column(name = "is_playing")
    private boolean isPlaying;  // 게임 진행중 여부

    @Column(name = "participants_count")
    private int participantsCount;  // 참가자 수

    @Column(name = "invite_code")
    private String inviteCode;  // 초대 코드
}
