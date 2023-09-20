package com.hk2.dap.domain.academy.service;

import com.hk2.dap.domain.academy.dto.AcademyRequestDto;
import com.hk2.dap.util.dto.MessageDto;
import org.springframework.http.ResponseEntity;

public interface AcademyService {

    ResponseEntity<MessageDto> academyJoin(AcademyRequestDto.AcademyJoin academyJoin);

    ResponseEntity<MessageDto> academyLogin(AcademyRequestDto.AcademyLogin academyLogin);

    ResponseEntity<MessageDto> lessonCreate(AcademyRequestDto.LessonCreate lessonCreate);
}
