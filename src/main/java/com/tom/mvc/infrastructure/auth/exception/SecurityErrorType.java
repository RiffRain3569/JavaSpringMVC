package com.tom.mvc.infrastructure.auth.exception;

import lombok.Getter;

@Getter
public enum SecurityErrorType {
    ;


    private final String message;

    SecurityErrorType(String message) {
        this.message = message;
    }
}
