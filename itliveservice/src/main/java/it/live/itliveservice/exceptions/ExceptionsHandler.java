package it.live.itliveservice.exceptions;


import it.live.itliveservice.Payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiResponse handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        return ApiResponse.builder().object(errors).status(400).build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiResponse exceptionAll(Exception e) {
        return ApiResponse
                .builder()
                .message(e.getMessage())
                .status(409)
                .build();
    }
}
