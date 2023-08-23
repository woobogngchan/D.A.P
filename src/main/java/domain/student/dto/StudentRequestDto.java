package domain.student.dto;

import domain.student.entity.StudentType;
import lombok.Getter;

public class StudentRequestDto {
    @Getter
    public class StudentJoin{
        private String studentId;
        private String studentPassword;
        private String studentName;
        private String nickName;
        private StudentType studentType;
        private String phoneNum;
        public StudentJoin(String studentId, String studentPassword, String studentName, String nickName, StudentType studentType, String phoneNum) {
            this.studentId = studentId;
            this.studentPassword = studentPassword;
            this.studentName = studentName;
            this.nickName = nickName;
            this.studentType = studentType;
            this.phoneNum = phoneNum;
        }
    }
}
