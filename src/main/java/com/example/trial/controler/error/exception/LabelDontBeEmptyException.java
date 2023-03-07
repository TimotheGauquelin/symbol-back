package com.example.trial.controler.error.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Getter
public class LabelDontBeEmptyException extends RuntimeException {

    private final String message;

    private final HttpStatus httpStatusMessage;

    public LabelDontBeEmptyException() {
        this.message = "The label can't be empty!";
        this.httpStatusMessage = HttpStatus.BAD_REQUEST;
    }
    public LabelDontBeEmptyException(String object) {
        this.message = "The label of this " + object + " can't be empty!";
        this.httpStatusMessage = HttpStatus.BAD_REQUEST;
    }

}
