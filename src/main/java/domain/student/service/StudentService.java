package domain.student.service;

import domain.student.dto.StudentRequestDto;
import domain.student.dto.StudentResponseDto;

public interface StudentService {
    String studentJoin(StudentRequestDto.StudentJoin studentJoin);
}
