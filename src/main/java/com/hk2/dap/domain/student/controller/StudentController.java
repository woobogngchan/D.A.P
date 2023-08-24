package com.hk2.dap.domain.student.controller;

import com.hk2.dap.domain.student.dto.StudentRequestDto;
import com.hk2.dap.domain.student.dto.StudentResponseDto;
import com.hk2.dap.domain.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/api/student")
    public String studentJoin(StudentRequestDto.StudentJoin studentJoin){
        return studentService.studentJoin(studentJoin);
    }

    @GetMapping("/api/stdent/login")
    public String studentLogin(StudentRequestDto.StudentLogin studentLogin){

        return studentService.studentLogin(studentLogin);

    }

}
