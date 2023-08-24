package com.hk2.dap.domain.student.repository;

import com.hk2.dap.domain.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByStudentIdAndStudentPassword(String studentId, String password);

}
