package com.example.trial.controler.error.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Getter
public class NameAlreadyExistsException extends RuntimeException{

    private final String message;

    private final HttpStatus httpStatusMessage;

    public NameAlreadyExistsException(){
        this.message = "Already exists !";
        this.httpStatusMessage = HttpStatus.BAD_REQUEST;
    }

    public NameAlreadyExistsException(String alreadyExistsSubject, String object) {
        this.message = "The name '" + alreadyExistsSubject + "' is a(n) " + object + " which already exists in the database !";
        this.httpStatusMessage = HttpStatus.BAD_REQUEST;
    }

}
