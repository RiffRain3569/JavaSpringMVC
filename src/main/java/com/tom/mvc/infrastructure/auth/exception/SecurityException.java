package com.tom.mvc.infrastructure.auth.exception;

import lombok.Getter;

@Getter
public class SecurityException extends IllegalArgumentException {
    private final SecurityErrorType securityErrorType;
    private final Object data;

    public SecurityException(SecurityErrorType userErrorType) {
        super(userErrorType.getMessage());
        this.securityErrorType = userErrorType;
        this.data = null;
    }

    public SecurityException(SecurityErrorType userErrorType, String message) {
        super(message);
        this.securityErrorType = userErrorType;
        this.data = null;
    }

    public SecurityException(SecurityErrorType userErrorType, String message, Object data) {
        super(message);
        this.securityErrorType = userErrorType;
        this.data = data;
    }
}
