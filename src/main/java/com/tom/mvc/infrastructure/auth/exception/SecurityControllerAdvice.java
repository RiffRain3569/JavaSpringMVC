package com.tom.mvc.infrastructure.auth.exception;

import com.tom.mvc.global.exception.CommonErrorRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackages = {"com.tom.mvc.infrastructure.security"})
public class SecurityControllerAdvice {
    @ExceptionHandler(SecurityException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonErrorRes codeError(SecurityException e) {
        return CommonErrorRes.of(e.getSecurityErrorType().name(), e.getMessage(), e.getData());
    }
}