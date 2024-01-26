package com.example.entity.repository;

import com.example.entity.domain.SingleHistory;
import com.example.entity.domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class SingleHistoryRepositoryTest {

    @PersistenceContext EntityManager em;
    @Autowired UserRepository userRepository;
    @Autowired SingleHistoryRepository singleHistoryRepository;

    @Test
    public void test() throws Exception {

        // given
        User user = User.builder()
                .email("a")
                .build();

        userRepository.save(user);

        SingleHistory singleHistory = SingleHistory.builder()
                .user(user)
                .trialCount(4)
                .isCorrect(true)
                .createDate(LocalDate.now())
                .resultText("success")
                .build();

        singleHistoryRepository.save(singleHistory);
//        SingleHistory.builder()
//                .user(user)
//                .trialCount(6)
//                .isCorrect(true)
//                .createDate(LocalDateTime.now())
//                .resultText("success")
//                .build();

        Long userId = userRepository.findByEmail("a").getId();
        LocalDate localDate = singleHistoryRepository.findById(1L).get().getCreateDate();


        System.out.println("user ::: " + user.getEmail() + " " + userId);
        System.out.println(localDate);
        // when

        // then

    }
}
