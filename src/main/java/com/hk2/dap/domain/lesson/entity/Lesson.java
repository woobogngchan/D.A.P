package com.hk2.dap.domain.lesson.entity;

import com.hk2.dap.domain.academy.entity.Academy;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String lessonName;

    @Column
    private int person;

    @Column
    private String lessonInfo;

    @Column
    private LessonJanreEnum janre;

    @Column
    private LessonTimeEnum lessonTimeEnum;

//    @Column
//    private Timestamp lessonDay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academyId", nullable = false)
    private Academy academy;

    @ManyToMany(mappedBy = "lesson", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<LessonStudent> studentList;

    @Builder
    public Lesson(String lessonName, int person, String lessonInfo, LessonJanreEnum janre, LessonTimeEnum lessonTimeEnum) {
        this.lessonName = lessonName;
        this.person = person;
        this.lessonInfo = lessonInfo;
        this.janre = janre;
        this.lessonTimeEnum = lessonTimeEnum;
//        this.lessonDay = lessonDay;
    }
}
