package com.hk2.dap.domain.student.serviceimpl;

import com.hk2.dap.domain.student.dto.StudentRequestDto;
import com.hk2.dap.domain.student.entity.Student;
import com.hk2.dap.domain.student.repository.StudentRepository;
import com.hk2.dap.domain.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public String studentJoin(StudentRequestDto.StudentJoin studentJoin) {
         Student student = Student.builder()
                 .studentId(studentJoin.getStudentId())
                 .studentName(studentJoin.getStudentName())
                 .studentPassword(studentJoin.getStudentPassword())
                 .studentType(studentJoin.getStudentType())
                 .nickName(studentJoin.getNickName())
                 .phoneNum(studentJoin.getPhoneNum())
                 .build();
        studentRepository.save(student);

        return "회원가입 완료!!";
    }

    @Override
    public String studentLogin(StudentRequestDto.StudentLogin studentLogin) {
       Student student = studentRepository.findByStudentIdAndStudentPassword(studentLogin.getStudentId(), studentLogin.getStudentPassword()).orElseThrow(() -> new IllegalArgumentException());
       return "로그인 되었습니다.";
    }
}
