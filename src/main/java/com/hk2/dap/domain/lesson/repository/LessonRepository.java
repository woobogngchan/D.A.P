package com.hk2.dap.domain.lesson.repository;

import com.hk2.dap.domain.academy.entity.Academy;
import com.hk2.dap.domain.lesson.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    Optional<Lesson> findByLessonName(String lessonName);
}
