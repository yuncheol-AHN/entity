package com.example.entity.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
class QuizroomRepositoryTest {

    @Autowired UserRepository userRepository;
    @Autowired QuizroomRepository quizroomRepository;
    @Autowired WordRepoitory wordRepoitory;

    /**
     * required : create, delete, ... play?! end? playing?
     * play : 질문리스트 줘야함
     * playing : 정답을 전달받아서 저장해야되나?
     * end : 최종 결과 줘야해?
     */
}