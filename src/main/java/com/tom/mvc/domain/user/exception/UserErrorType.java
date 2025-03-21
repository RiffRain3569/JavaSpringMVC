package com.tom.mvc.domain.user.exception;

import lombok.Getter;

@Getter
public enum UserErrorType {
    USER_SIGN_UP_DUPLICATE_EMAIL("중복된 이메일 입니다."),
    ;


    private final String message;

    UserErrorType(String message) {
        this.message = message;
    }
}
