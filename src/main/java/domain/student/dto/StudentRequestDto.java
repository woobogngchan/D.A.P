package domain.student.dto;

import domain.student.entity.StudentType;
import lombok.Getter;

public class StudentRequestDto {
    @Getter
    public static class StudentJoin{
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
    @Getter
    public static class StudentLogin{

        private String studentId;
        private String studentPassword;

        public StudentLogin(String studentId, String studentPassword) {
            this.studentId = studentId;
            this.studentPassword = studentPassword;
        }
    }


}
