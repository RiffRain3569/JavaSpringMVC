package com.tom.mvc.global.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class CommonControllerAdvice {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public CommonErrorRes notExistParameter(HttpMessageNotReadableException e) {
        if (log.isDebugEnabled()) {
            log.error("error : ", e);
        } else {
            this.printProdLog(e);
        }
        return CommonErrorRes.of(CommonErrorType.COMMON_INVALID);
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonErrorRes systemError(Exception e) {
        if (log.isDebugEnabled()) {
            log.error("error : ", e);
        } else {
            this.printProdLog(e);
        }
        return CommonErrorRes.of(CommonErrorType.COMMON_INVALID);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public CommonErrorRes handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        if (log.isDebugEnabled()) {
            log.error("MethodArgumentNotValidError : ", e);
        } else {
            this.printProdLog(e);
        }
        return CommonErrorRes.of(CommonErrorType.COMMON_INVALID, e.getBindingResult().getAllErrors().getFirst().getDefaultMessage());
    }

    private void printProdLog(Exception e) {
        log.error(e.getClass().getName() + ": " + e.getMessage());
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (int i = 0; i < 5; i++) {
            log.error("    at " + stackTrace[i]);
        }
    }
}