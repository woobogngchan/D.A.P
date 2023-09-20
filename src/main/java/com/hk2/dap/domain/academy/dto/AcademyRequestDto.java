package com.hk2.dap.domain.academy.dto;

import com.hk2.dap.domain.academy.entity.AcademyCiyEnum;
import com.hk2.dap.domain.academy.entity.AcademyDistrictEnum;
import com.hk2.dap.domain.lesson.entity.LessonJanreEnum;
import com.hk2.dap.domain.lesson.entity.LessonTimeEnum;
import lombok.Getter;

import javax.persistence.Column;
import java.sql.Timestamp;

public class AcademyRequestDto {
    @Getter
    public static class AcademyJoin {
        private String academyId;
        private String academyPassword;
        private String academyName;
        private String academyInfo;
        private AcademyCiyEnum city;
        private AcademyDistrictEnum district;
        private String address;
        private float rating;
        private String academyPhoneNum;

        public AcademyJoin(String academyId, String academyPassword, String academyName, String academyInfo, AcademyCiyEnum city, AcademyDistrictEnum district, String address, float rating, String academyPhoneNum) {
            this.academyId = academyId;
            this.academyPassword = academyPassword;
            this.academyName = academyName;
            this.academyInfo = academyInfo;
            this.city = city;
            this.district = district;
            this.address = address;
            this.rating = rating;
            this.academyPhoneNum = academyPhoneNum;
        }
    }
    @Getter
    public static class AcademyLogin{
        private String academyId;
        private String academyPassword;

        public AcademyLogin(String academyId, String academyPassword){
            this.academyId = academyId;
            this.academyPassword = academyPassword;
        }

    }

    @Getter
    public static class LessonCreate{

        private String lessonName;

        private int person;

        private String lessonInfo;

        private LessonJanreEnum janre;

        private LessonTimeEnum lessonTimeEnum;

        private Timestamp lessonDay;

        public LessonCreate(String lessonName, int person, String lessonInfo, LessonJanreEnum janre, LessonTimeEnum lessonTimeEnum, Timestamp lessonDay) {
            this.lessonName = lessonName;
            this.person = person;
            this.lessonInfo = lessonInfo;
            this.janre = janre;
            this.lessonTimeEnum = lessonTimeEnum;
            this.lessonDay = lessonDay;
        }
    }


}
