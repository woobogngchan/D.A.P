package com.hk2.dap.domain.user.dto;

import com.hk2.dap.domain.user.entity.UserType;

import lombok.Getter;

public class UserRequestDto {
    @Getter
    public static class UserJoin{
        private String userId;
        private String userPassword;
        private String userName;
        private String nickName;
        private UserType userType;
        private String phoneNum;
        public UserJoin(String userId, String userPassword, String userName, String nickName, UserType userType, String phoneNum) {
            this.userId = userId;
            this.userPassword = userPassword;
            this.userName = userName;
            this.nickName = nickName;
            this.userType = userType;
            this.phoneNum = phoneNum;
        }
    }
    @Getter
    public static class UserLogin{
        private String userId;
        private String userPassword;

        public UserLogin(String userId, String userPassword) {
            this.userId = userId;
            this.userPassword = userPassword;
        }
    }


}
