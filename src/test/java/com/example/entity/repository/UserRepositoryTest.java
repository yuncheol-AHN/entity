package com.example.entity.repository;

import com.example.entity.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    /**
     * 생성
     * 조회(1, ALL)
     * 수정
     */

    @Test
    public void createUser() throws Exception {

        // given
        User user = User.builder()
                .socialId("yuncheol2")
                .nickname("jparepotest")
                .level(10)
                .exp(300)
                .isPlaying(false)
                .recentCorrectCount(30)
                .maxCorrectCount(20)
                .imageUrl("blblbl.com")
                .build();

        // 생성
        userRepository.save(user);
        User findUser = userRepository.findById(user.getId()).get();

        // then
        assertThat(user).isEqualTo(findUser);
    }

    @Test
    public void findUser() throws Exception {
        // why? 1 -> .get(), all -> not
        // given
        User user = userRepository.findById(Long.valueOf(2)).get();
        List<User> users = userRepository.findAll();

        // do


        // then

        assertThat(user.getExp()).isEqualTo(5000);
        assertThat(users.size()).isEqualTo(2);
    }

    @Test
    public void updateUser() throws Exception {

        // given
        User user = userRepository.findBySocialId("yuncheol");

        System.out.println("user : " + user.getId());
        User newUser = user.toBuilder()    // 설정 필요 !!!
                .exp(5000)
                .build();

        userRepository.save(newUser);   // id값을 기준으로 덮어쓰나?

        // do

        // then
    }
}