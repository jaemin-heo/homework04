package com.kh.homework04.exception;

import jakarta.persistence.NoResultException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorProcessor {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> m01(Exception e){
        Map<String, Object> body = new HashMap<>();
        body.put("error",e.getMessage());
        body.put("message", "에러");

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(body);
    }
}
