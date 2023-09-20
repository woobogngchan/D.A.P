package com.hk2.dap.domain.lesson.entity;

import com.hk2.dap.domain.student.entity.Student;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class LessonStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;

    public LessonStudent(Student student, Lesson lesson) {
        this.student = student;
        this.lesson = lesson;
    }
}
