package com.eduardadebrum.srmBackend.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eduarda de Brum Lucena
// */
@ControllerAdvice
public class ResponseEntityException extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<ErrorException> errorExceptions = new ArrayList<>();


        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errorExceptions.add(new ErrorException(error.getObjectName() + ": " + error.getDefaultMessage()));
        }

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errorExceptions.add(new ErrorException(error.getField(), error.getDefaultMessage()));
        }

        return super.handleExceptionInternal(ex, errorExceptions, headers, status, request);
    }

}