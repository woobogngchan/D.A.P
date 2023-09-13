package com.hk2.dap.domain.academy.dto;

import com.hk2.dap.domain.academy.entity.AcademyCiyEnum;
import com.hk2.dap.domain.academy.entity.AcademyDistrictEnum;
import lombok.Getter;

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


}
