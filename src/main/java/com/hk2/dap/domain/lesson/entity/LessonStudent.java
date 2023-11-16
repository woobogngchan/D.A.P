package com.hk2.dap.domain.lesson.entity;

import com.hk2.dap.domain.user.entity.User;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class LessonStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lessonId", nullable = false)
    private Lesson lesson;

    public LessonStudent(User user, Lesson lesson) {
        this.user = user;
        this.lesson = lesson;
    }
}
