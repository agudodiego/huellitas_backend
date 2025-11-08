package com.huellitas_backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExceptionHandler {

    /* 500 */
    @ExceptionHandler(ErrorProcessException.class)
    @ResponseBody
    public ResponseEntity handleErrorProcessException(ErrorProcessException e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .body(Map.of("error", "Internal Server Error", "message", e.getMessage()));
    }

    /* Elementos no encontrados */
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ResponseEntity handleNotFoundException(NotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value())
                .body(Map.of("error", "Not Found", "message", e.getMessage()));
    }

    /* Elemento duplicado */
    @ExceptionHandler(DuplicateException.class)
    @ResponseBody
    public ResponseEntity handleDuplicateException(DuplicateException e){
        return ResponseEntity.status(HttpStatus.CONFLICT.value())
                .body(Map.of("error", "Conflict", "message", e.getMessage()));
    }
}
