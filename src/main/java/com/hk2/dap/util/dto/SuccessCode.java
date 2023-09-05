package com.hk2.dap.util.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessCode {
    JOIN_SUCCESS(HttpStatus.OK, "registration success"),
    LOGIN_SUCCESS(HttpStatus.OK, "login success"),
    CHECKUP_EMAIL(HttpStatus.OK, "email available"),
    VALID_EMAIL(HttpStatus.OK, "valid email"),
    LOGOUT_SUCCESS(HttpStatus.OK, "bye bye"),
    STATUS_CHANGED(HttpStatus.OK, "status change success"),
    DELETE_SUCCESS(HttpStatus.OK, "delete success"),
    ORDER_CHANGE_SUCCESS(HttpStatus.OK, "order changed"),
    INVITE_SUCCESS(HttpStatus.OK, "invite success"),
    INVITE_REJECT(HttpStatus.OK, "invite reject success"),
    CANCEL_INVITE(HttpStatus.OK, "invite canceled"),
    RESET_PASSWORD_SUCCESS(HttpStatus.OK, "reset password success"),
    VALID_CODE(HttpStatus.OK, "valid code"),
    EXILE_SUCCESS(HttpStatus.OK, "exile success"),
    FIND_SUCCESS(HttpStatus.OK,"find");

    private final HttpStatus httpStatus;
    private final String message;
}
