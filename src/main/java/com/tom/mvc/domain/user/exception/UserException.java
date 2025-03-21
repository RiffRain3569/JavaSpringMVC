package com.tom.mvc.domain.user.exception;

import lombok.Getter;

@Getter
public class UserException extends IllegalArgumentException {
    private final UserErrorType userErrorType;
    private final Object data;

    public UserException(UserErrorType userErrorType) {
        super(userErrorType.getMessage());
        this.userErrorType = userErrorType;
        this.data = null;
    }

    public UserException(UserErrorType userErrorType, String message) {
        super(message);
        this.userErrorType = userErrorType;
        this.data = null;
    }

    public UserException(UserErrorType userErrorType, String message, Object data) {
        super(message);
        this.userErrorType = userErrorType;
        this.data = data;
    }
}
