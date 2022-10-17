package com.example.registrationandloginservice.ExceptionHandlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


@ControllerAdvice
public class ExceptionHandler{

    @Autowired //need to read about the differences between Bean and Component
    ValidationErrors validationErrors;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrors> MethodArgumentNotValidException(MethodArgumentNotValidException e)
    {
        validationErrors.setValidationErrorMessage(e.getFieldError().getDefaultMessage());
        return ResponseEntity.badRequest().body(validationErrors);
    }
}
