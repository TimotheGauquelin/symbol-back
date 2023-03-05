package com.example.trial.controler.error;

import com.example.trial.controler.error.exception.EntityDontExistException;
import com.example.trial.controler.error.exception.IdMustBeNullException;
import com.example.trial.controler.error.exception.NameAlreadyExistsException;
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

    @ExceptionHandler(NameAlreadyExistsException.class)
    protected ResponseEntity<String> handleNameAlreadyExists(NameAlreadyExistsException nameAlreadyExistsException) {
        return ResponseEntity.badRequest().body(nameAlreadyExistsException.getMessage());
    }

    @ExceptionHandler(EntityDontExistException.class)
    protected ResponseEntity<String> handleApologyDontExistException(EntityDontExistException apologyDontExistException) {
        return ResponseEntity.badRequest().body(apologyDontExistException.getMessage());
    }

}
