package com.hk2.dap.domain.academy.serviceimpl;

import com.hk2.dap.domain.academy.dto.AcademyRequestDto;
import com.hk2.dap.domain.academy.entity.Academy;
import com.hk2.dap.domain.academy.entity.AcademyCiyEnum;
import com.hk2.dap.domain.academy.entity.AcademyDistrictEnum;
import com.hk2.dap.domain.academy.repository.AcademyRepository;
import com.hk2.dap.domain.academy.service.AcademyService;
import com.hk2.dap.domain.lesson.entity.Lesson;
import com.hk2.dap.domain.lesson.repository.LessonRepository;
import com.hk2.dap.util.dto.ErrorCode;
import com.hk2.dap.util.dto.MessageDto;
import com.hk2.dap.util.dto.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AcademyServiceImpl implements AcademyService {

    private final AcademyRepository academyRepository;
    private final LessonRepository lessonRepository;


    @Override
    public ResponseEntity<MessageDto> academyJoin(AcademyRequestDto.AcademyJoin academyJoin) {

        Optional<Academy> academyId = academyRepository.findByAcademyId((academyJoin.getAcademyId()));

        if(academyId.isPresent()){
            throw new MessageDto(ErrorCode.INVALID_CODE);
        }

        Academy academy = Academy.builder()
                .academyId(academyJoin.getAcademyId())
                .academyName(academyJoin.getAcademyName())
                .academyPassword(academyJoin.getAcademyPassword())
                .academyInfo(academyJoin.getAcademyInfo())
                .academyPhoneNum(academyJoin.getAcademyPhoneNum())
                .city(academyJoin.getCity())
                .district(academyJoin.getDistrict())
                .build();
        academyRepository.save(academy);

        return MessageDto.toResponseEntity(SuccessCode.JOIN_SUCCESS);
    }

    @Override
    public ResponseEntity<MessageDto> academyLogin(AcademyRequestDto.AcademyLogin academyLogin) {

        Academy academy = academyRepository.findByAcademyIdAndAcademyPassword(academyLogin.getAcademyId(), academyLogin.getAcademyPassword()).orElseThrow(() -> new MessageDto(ErrorCode.DUPLICATE_EMAIL));

        return ResponseEntity.ok()
               // .headers(headers)
                .body(MessageDto.of(SuccessCode.LOGIN_SUCCESS));
    }

    @Override
    public ResponseEntity<MessageDto> lessonCreate(AcademyRequestDto.LessonCreate lessonCreate) {
        Optional<Lesson> lesson = lessonRepository.findByLessonName(lessonCreate.getLessonName());

        if(lesson.isPresent()){
            throw new MessageDto(ErrorCode.INVALID_CODE);
        }

        Lesson lesons = Lesson.builder()
                .janre(lessonCreate.getJanre())
                .lessonName(lessonCreate.getLessonName())
                .lessonTimeEnum(lessonCreate.getLessonTimeEnum())
                .lessonDay(lessonCreate.getLessonDay())
                .lessonInfo(lessonCreate.getLessonInfo())
                .person(lessonCreate.getPerson())
                .build();

        return ResponseEntity.ok()
                .body(MessageDto.of(SuccessCode.VALID_CODE));
    }
}
