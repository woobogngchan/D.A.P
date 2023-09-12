package com.hk2.dap.util.dto;

import lombok.Getter;

import java.util.concurrent.CompletionException;

@Getter
public class CustomException extends CompletionException {

    private final ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
