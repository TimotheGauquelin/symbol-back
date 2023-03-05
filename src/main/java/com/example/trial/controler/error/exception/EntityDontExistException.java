package com.example.trial.controler.error.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Getter
public class EntityDontExistException extends RuntimeException{

    private final String message;

    private final HttpStatus httpStatusMessage;

    public EntityDontExistException() {
        this.message = "This entity don't exist in database !";
        this.httpStatusMessage = HttpStatus.BAD_REQUEST;
    }

    public EntityDontExistException(String entity) {
        this.message = "This " + entity + " don't exist in database !";
        this.httpStatusMessage = HttpStatus.BAD_REQUEST;
    }

}
