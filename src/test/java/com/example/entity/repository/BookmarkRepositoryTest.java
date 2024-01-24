package com.example.entity.repository;

import com.example.entity.domain.Bookmark;
import com.example.entity.domain.Category;
import com.example.entity.domain.User;
import com.example.entity.domain.Word;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class BookmarkRepositoryTest {

    @Autowired WordRepoitory wordRepoitory;
    @Autowired UserRepository userRepository;
    @Autowired BookmarkRepository bookmarkRepository;

    /**
     * required : create, find ...
     */

    @Test
    public void createBookmark() throws Exception {
        /**
         * 0. 단어를 북마크에 저장할까 유저에 저장할까 -> 단어를 북마크에 담아 유저가 가지고 있는 북마크 리스트에 저장하자.
         * 1. make word list
         * 2. add to bookmark(user id, word id)
         * 3. select * from bookmark where user id = 'A'
         */

        /**
         * 두번 째 방법
         * 1. create word, user : 단어, 유저를 만들고
         * 2. create bookmark : 이를 매개변수로 북마크를 만든다
         * 3. save word, user, bookmark : 그리고 단어, 유저, 북마크를 DB에 저장
         */

        /**
         * Problem.
         * 중복 저장되는 문제 ... 어디서 처리해줄까
         */
        // given
        Word word1 = Word.builder()
                .category(Category.CONSONANT)
                .wordName("a")
                .videoUrl("blabla")
                .build();

        Word word2 = Word.builder()
                .category(Category.CONSONANT)
                .wordName("b")
                .videoUrl("blabla")
                .build();

        Word word3 = Word.builder()
                .category(Category.CONSONANT)
                .wordName("c")
                .videoUrl("blabla")
                .build();

        wordRepoitory.save(word1);
        wordRepoitory.save(word2);
        wordRepoitory.save(word3);

        User user = User.builder()
                .email("yuncheol2")
                .nickname("jparepotest")
                .level(10)
                .exp(300)
                .isPlaying(false)
                .recentCorrectCount(30)
                .maxCorrectCount(20)
                .imageUrl("blblbl.com")
                .bookmarkList(new ArrayList<>())
                .build();

        Bookmark bookmark1 = Bookmark.builder()
                .word(word1)
                .user(user)
                .build();
        Bookmark bookmark2 = Bookmark.builder()
                .word(word2)
                .user(user)
                .build();
        Bookmark bookmark3 = Bookmark.builder()
                .word(word3)
                .user(user)
                .build();
//        user.getBookmarkList().add(bookmark1);


        userRepository.save(user);
        bookmarkRepository.save(bookmark1);
        bookmarkRepository.save(bookmark2);
        bookmarkRepository.save(bookmark3);
        // when
        
        // then
    }

    @Test
    public void findBookmark() throws Exception {

        /**
         * 1. find user by social id
         * 2. find all bookmarks
         * 3. select * from bookmarks join user.id and bookmark.id
         */
        // given
        List<Bookmark> bookmarks = bookmarkRepository.findAll();

        System.out.println("--------------------절취선-------------------");
        for (Bookmark bookmark: bookmarks) {
            System.out.println(bookmark.getUser().getEmail());
        }

        // when

        // then
    }
}