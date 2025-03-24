package com.tom.mvc.global.exception;

import lombok.Getter;

@Getter
public enum CommonErrorType {
    INVALID_COMMON("잘못된 요청입니다."),
    INVALID_PARAMETER("입력 파라미터가 잘못되었습니다.");

    private final String message;

    CommonErrorType(String message) {
        this.message = message;
    }
}
