package com.lab02.exception;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice // 전역 예외처리 클라스로 명시하겟다  
public class GlobalExceptionHandler { 
 
    //(1) 유효성 검증 실패 처리 
    @ExceptionHandler(MethodArgumentNotValidException.class) 
    public ResponseEntity<String> 
handleValidationException(MethodArgumentNotValidException ex) { 
        String errorMessage = ex.getBindingResult() 
                                .getAllErrors() 
                                .get(0) 
                                .getDefaultMessage(); 
        return ResponseEntity 
                .badRequest() 
                .body(errorMessage); 
    } 
   
    // (2) 엔티티를 찾지 못했을 때 처리 
    @ExceptionHandler(EntityNotFoundException.class) 
    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException 
ex) { 
        return ResponseEntity 
                .status(HttpStatus.NOT_FOUND) 
                .body("case 2: " + ex.getMessage()); 
    } 
    // (3) 그 외의 예외 처리 
    @ExceptionHandler(Exception.class) 
    public ResponseEntity<String> handleOtherExceptions(Exception ex) { 
        return ResponseEntity 
                .status(HttpStatus.INTERNAL_SERVER_ERROR) 
                .body("알 수 없는 오류가 발생했습니다: " + ex.getMessage()); 
    } 
}
