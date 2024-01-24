package com.example.entity.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder(toBuilder = true) // 수정을 하고 싶을 때 toBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
public class Subject {

    @Id @GeneratedValue
    @Column(name = "subject_id")
    private Long id;

    @OneToMany(mappedBy = "subject")
    private List<Word> wordList;

    private String subjectName;

    @Builder
    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public void addWord(Word word) {
        System.out.println("2:::" + word);
        this.wordList.add(word);
        word = word.toBuilder().subject(this).build();

        /**
         * wordList에서 word를 찾아서
         * 그 값의 subjectName을 바꿔준다.
         */

//        for (Word w: wordList) {
//
//            w.get
//        }
//
//        word.toBuilder()
//                .subject(this)
//                .build();
    }

    // -- business method --//
    // update subject name
//    public void updateSubjectName(String subjectName) {
//
//        subjectName();
//
//        for (Word word: wordList) {
//            word.toBuilder()
//                    .subject(this)
//                    .build();
//        }
//    }

}
