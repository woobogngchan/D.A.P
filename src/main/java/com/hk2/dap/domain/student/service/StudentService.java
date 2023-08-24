package com.hk2.dap.domain.student.service;

import com.hk2.dap.domain.student.dto.StudentRequestDto;
import com.hk2.dap.domain.student.dto.StudentResponseDto;

public interface StudentService {
    String studentJoin(StudentRequestDto.StudentJoin studentJoin);

    String studentLogin(StudentRequestDto.StudentLogin studentLogin);
}
