package com.example.trial.controler.error;

import com.example.trial.controler.error.exception.IdMustBeNullException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionTranslator extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IdMustBeNullException.class)
    protected ResponseEntity<String> handleIdMustBeNull(IdMustBeNullException idMustBeNullException) {
        return ResponseEntity.badRequest().body(idMustBeNullException.getMessage());
    }

}
