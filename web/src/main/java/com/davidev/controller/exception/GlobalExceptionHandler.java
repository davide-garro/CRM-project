package com.davidev.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.net.URI;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler{
    @ExceptionHandler(exception = NoResourceFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoResourceFoundException(NoResourceFoundException exception, WebRequest webRequest){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .header("correlation-id","")
                .body(ErrorResponse.builder()
                        .withTitle("Not Found")
                        .withDetails("No resource available for the specified url")
                        .withStatus(HttpStatus.NOT_FOUND.value())
                        .withTraceId("")
                        .withPath(URI.create(webRequest.getContextPath()))
                        .withTimestamp(LocalDateTime.now())
                        .build()
                );
    }
}
