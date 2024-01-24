package com.example.entity.repository;

import com.example.entity.domain.Category;
import com.example.entity.domain.Subject;
import com.example.entity.domain.Word;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class WordRepoitoryTest {

    @Autowired WordRepoitory wordRepoitory;

    @Test
    public void createWord() throws Exception {

        /**
         * case 1 subject가 존재 O
         * case 2 subject가 존재 X
         */
        // subject 존재 X
        Subject subject = Subject.builder()
                .subjectName("fruit")
                .build();

        // subject 존재 O
//        subject

        // given
        Word apple = Word.builder()
                .wordName("banana")
                .category(Category.WORD)
                .subject(subject)    // 요상함...   // entitiy
                .videoUrl("url").build();

        // when
        wordRepoitory.save(apple);

        // then
        Word findWord = wordRepoitory.findByWordName("apple");
        assertThat(apple.getWordName()).isEqualTo(findWord.getWordName());

    }
}