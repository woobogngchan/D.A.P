package com.hk2.dap.domain.student.service;

import com.hk2.dap.domain.student.dto.StudentRequestDto;
import com.hk2.dap.domain.student.dto.StudentResponseDto;
import com.hk2.dap.util.dto.MessageDto;
import org.springframework.http.ResponseEntity;

public interface StudentService {
    ResponseEntity<MessageDto> studentJoin(StudentRequestDto.StudentJoin studentJoin);

    ResponseEntity<MessageDto> studentLogin(StudentRequestDto.StudentLogin studentLogin);
}
