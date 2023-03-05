package com.example.trial.controler.error.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Getter
public class IdMustBeNullException extends RuntimeException {

    private final String message;

    private final HttpStatus httpStatusMessage;

    public IdMustBeNullException() {
        this.message = "Id must be null !";
        this.httpStatusMessage = HttpStatus.BAD_REQUEST;
    }

}
