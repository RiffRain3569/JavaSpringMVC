package com.tom.mvc.global.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonErrorRes {
    private String error;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    public static CommonErrorRes from(CommonErrorType commonErrorType) {
        return new CommonErrorRes(
                commonErrorType.name(),
                commonErrorType.getMessage(),
                null
        );
    }

    public static CommonErrorRes of(CommonErrorType commonErrorType, String message) {
        return new CommonErrorRes(
                commonErrorType.name(),
                message,
                null
        );
    }

    public static CommonErrorRes of(String error, String message, Object data) {
        return new CommonErrorRes(
                error,
                message,
                data
        );
    }
}
