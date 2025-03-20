package com.tom.mvc.global.exception;

import lombok.Getter;

@Getter
public enum CommonErrorType {
    COMMON_INVALID("잘못된 요청입니다."),
    ;

    private final String message;

    CommonErrorType(String message) {
        this.message = message;
    }
}
