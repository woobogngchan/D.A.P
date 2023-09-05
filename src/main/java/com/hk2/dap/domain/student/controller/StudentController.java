package com.hk2.dap.domain.student.controller;

import com.hk2.dap.domain.student.dto.StudentRequestDto;
import com.hk2.dap.domain.student.dto.StudentResponseDto;
import com.hk2.dap.domain.student.service.StudentService;
import com.hk2.dap.util.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/api/student")
    public ResponseEntity<MessageDto> studentJoin(StudentRequestDto.StudentJoin studentJoin){
        return studentService.studentJoin(studentJoin);
    }

    @GetMapping("/api/student/login")
    public ResponseEntity<MessageDto> studentLogin(StudentRequestDto.StudentLogin studentLogin){

        return studentService.studentLogin(studentLogin);
    }

}
