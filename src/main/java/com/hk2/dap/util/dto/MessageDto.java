package com.hk2.dap.util.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Getter
public class MessageDto {
    private final String message;
    private final String code;
    private final int statusCode;

    @Builder
    public MessageDto(String message, String code, int statusCode) {
        this.message = message;
        this.code = code;
        this.statusCode = statusCode;
    }

    public static MessageDto of(SuccessCode successCode) {
        return MessageDto.builder()
                .message(successCode.getMessage())
                .statusCode(successCode.getHttpStatus().value())
                .build();
    }

    public static MessageDto of(ErrorCode errorCode) {
        return MessageDto.builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .statusCode(errorCode.getHttpStatus().value())
                .build();
    }

    public static ResponseEntity<MessageDto> toResponseEntity(SuccessCode successCode) {
        return ResponseEntity.status(successCode.getHttpStatus().value())
                .body(MessageDto.builder()
                        .message(successCode.getMessage())
                        .statusCode(successCode.getHttpStatus().value())
                        .build());
    }

    public static ResponseEntity<MessageDto> toResponseEntity(ErrorCode errorCode) {
        return ResponseEntity.status(errorCode.getHttpStatus().value())
                .body(MessageDto.builder()
                        .code(errorCode.getCode())
                        .message(errorCode.getMessage())
                        .statusCode(errorCode.getHttpStatus().value())
                        .build());
    }
}
