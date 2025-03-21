package com.tom.mvc.domain.user.exception;

import com.tom.mvc.global.exception.CommonErrorRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackages = {"com.tom.mvc.domain.user"})
public class UserControllerAdvice {
    @ExceptionHandler(UserException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonErrorRes codeError(UserException e) {
        return CommonErrorRes.of(e.getUserErrorType().name(), e.getMessage(), e.getData());
    }
}