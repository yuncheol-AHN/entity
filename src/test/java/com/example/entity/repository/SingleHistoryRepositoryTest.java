package com.example.entity.repository;

import com.example.entity.domain.SingleHistory;
import com.example.entity.domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class SingleHistoryRepositoryTest {

    @PersistenceContext EntityManager em;
    @Autowired UserRepository userRepository;
    @Autowired SingleHistoryRepository singleHistoryRepository;

    @Test
    public void test() throws Exception {

        // create & read
        User user = User.builder()
                .email("a")
                .build();

        if (userRepository.findByEmail(user.getEmail()) == null) {
            userRepository.save(user);
        }

        SingleHistory history = SingleHistory.builder()
                .user(user)
                .trialCount(4)
                .isCorrect(true)
                .createDate(LocalDate.now())
                .resultText("success")
                .build();

        if (singleHistoryRepository.findByCreateDate(history.getCreateDate()) == null) {
            singleHistoryRepository.save(history);
        }

        SingleHistory history2 = SingleHistory.builder()
                .user(user)
                .trialCount(6)
                .isCorrect(true)
                .createDate(LocalDate.of(2024, 1,25))
                .resultText("success")
                .build();

        if (singleHistoryRepository.findByCreateDate(history2.getCreateDate()) == null) {
            singleHistoryRepository.save(history2);
        }

        SingleHistory duplDateHistory = SingleHistory.builder()
                .user(user)
                .trialCount(1)
                .isCorrect(true)
                .createDate(LocalDate.now())
                .resultText("success")
                .build();

        if (singleHistoryRepository.findByCreateDate(duplDateHistory.getCreateDate()) == null) {
            singleHistoryRepository.save(duplDateHistory);
        }

        Long userId = userRepository.findByEmail("a").getId();
        LocalDate localDate = singleHistoryRepository.findByCreateDate(LocalDate.now()).getCreateDate();

        assertThat(user).isEqualTo(userRepository.findByEmail(user.getEmail()));
        assertThat(history).isEqualTo(singleHistoryRepository.findByCreateDate(history.getCreateDate()));
        // exception 처리 해줬을 때 에러코드
        assertThatThrownBy(() -> {
            /**
             * 예외 발생 코드
             */
            singleHistoryRepository.findByCreateDate()
            throw new Exception("");
        })
        .isInstanceOf(Exception.class)
        .hasMessageContaining("");





        // update

        // then

    }
}
