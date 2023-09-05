package com.hk2.dap.domain.student.serviceimpl;

import com.hk2.dap.domain.student.dto.StudentRequestDto;
import com.hk2.dap.domain.student.entity.Student;
import com.hk2.dap.domain.student.repository.StudentRepository;
import com.hk2.dap.domain.student.service.StudentService;
import com.hk2.dap.util.dto.CustomException;
import com.hk2.dap.util.dto.ErrorCode;
import com.hk2.dap.util.dto.MessageDto;
import com.hk2.dap.util.dto.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public ResponseEntity<MessageDto> studentJoin(StudentRequestDto.StudentJoin studentJoin) {
         Student student = Student.builder()
                 .studentId(studentJoin.getStudentId())
                 .studentName(studentJoin.getStudentName())
                 .studentPassword(studentJoin.getStudentPassword())
                 .studentType(studentJoin.getStudentType())
                 .nickName(studentJoin.getNickName())
                 .phoneNum(studentJoin.getPhoneNum())
                 .build();
        studentRepository.save(student);

        return MessageDto.toResponseEntity(SuccessCode.JOIN_SUCCESS);
    }

    @Override
    public ResponseEntity<MessageDto> studentLogin(StudentRequestDto.StudentLogin studentLogin) {
       Student student = studentRepository.findByStudentIdAndStudentPassword(studentLogin.getStudentId(), studentLogin.getStudentPassword()).orElseThrow(() -> new CustomException(ErrorCode.DUPLICATE_EMAIL));
       return MessageDto.toResponseEntity(SuccessCode.LOGIN_SUCCESS);
    }
}
