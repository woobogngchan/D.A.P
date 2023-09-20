package com.hk2.dap.domain.student.entity;

import com.hk2.dap.domain.academy.entity.Academy;
import com.hk2.dap.domain.lesson.entity.Lesson;
import com.hk2.dap.domain.lesson.entity.LessonStudent;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String  studentId;

    @Column
    private String studentPassword;

    @Column(nullable = false)
    private String studentName;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false)
    private StudentType studentType;

    @Column(nullable = false)
    private String phoneNum;

    @ManyToMany(mappedBy = "student", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<LessonStudent> lessonList;

    @Builder
    public Student(Long id, String studentId, String studentPassword, String studentName, String nickName, StudentType studentType, String phoneNum) {
        this.id = id;
        this.studentId = studentId;
        this.studentPassword = studentPassword;
        this.studentName = studentName;
        this.nickName = nickName;
        this.studentType = studentType;
        this.phoneNum = phoneNum;
    }
}
