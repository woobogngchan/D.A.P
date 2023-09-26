package com.hk2.dap.domain.academy.controller;

import com.hk2.dap.domain.academy.dto.AcademyRequestDto;
import com.hk2.dap.domain.academy.service.AcademyService;
import com.hk2.dap.util.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
public class AcademyController {

    private final AcademyService academyService;
    @GetMapping("/api/academy/join")
    public ResponseEntity<MessageDto> academyJoin(AcademyRequestDto.AcademyJoin academyJoin){

        return academyService.academyJoin(academyJoin);

    }

    @GetMapping("/api/academy/login")
    public ResponseEntity<MessageDto> academyLogin(AcademyRequestDto.AcademyLogin academyLogin){

        return academyService.academyLogin(academyLogin);

    }

    @GetMapping("/api/academy/lesson")
    public ResponseEntity<MessageDto> lessonCreate(AcademyRequestDto.LessonCreate lessonCreate){

        return academyService.lessonCreate(lessonCreate);

    }

}
