package com.hk2.dap.domain.student.serviceimpl;

import com.hk2.dap.domain.student.dto.StudentRequestDto;
import com.hk2.dap.domain.student.entity.Student;
import com.hk2.dap.domain.student.repository.StudentRepository;
import com.hk2.dap.domain.student.service.StudentService;
//import com.hk2.dap.security.jwt.JwtUtil;
//import com.hk2.dap.util.dto.CustomException;
import com.hk2.dap.util.dto.ErrorCode;
import com.hk2.dap.util.dto.MessageDto;
import com.hk2.dap.util.dto.SuccessCode;
import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

//    private final JwtUtil jwtUtil;

//    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<MessageDto> studentJoin(StudentRequestDto.StudentJoin studentJoin) {
//        String password = passwordEncoder.encode(studentJoin.getStudentPassword());

        Optional<Student> studentId = studentRepository.findByStudentId((studentJoin.getStudentId()));

        if (studentId.isPresent()) {
            throw new MessageDto(ErrorCode.DUPLICATE_EMAIL);
        }

        Student student = Student.builder()
                .studentId(studentJoin.getStudentId())
                .studentName(studentJoin.getStudentName())
//                .studentPassword(password)
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
        Student student = studentRepository.findByStudentId(studentLogin.getStudentId()).orElseThrow(() -> new MessageDto(ErrorCode.DUPLICATE_EMAIL));

//        if (!passwordEncoder.matches(studentLogin.getStudentPassword(), student.getStudentPassword()))
//            throw new MessageDto(ErrorCode.DUPLICATE_EMAIL);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.set(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(student.getStudentId()));

        return ResponseEntity.ok()
//                .headers(headers)
                .body(MessageDto.of(SuccessCode.LOGIN_SUCCESS));
    }
}