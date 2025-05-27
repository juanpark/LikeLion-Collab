package com.lab02.exception;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.MethodArgumentNotValidException;

//@ControllerAdvice // 전역 예외처리 클라스로 명시하겟다
public class GlobalExceptionHandler02 {
	// (1) 유효성 검증 실패 처리
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ModelAndView handleValidationException(MethodArgumentNotValidException ex) {
		String errorMessage = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();

		ModelAndView mav = new ModelAndView("myerror"); // myerror.html 뷰이름
		mav.addObject("errorMessage", errorMessage);
		return mav;
	}

	// (2) 엔티티를 찾지 못했을 때 처리
	@ExceptionHandler(EntityNotFoundException.class)
	public ModelAndView handleEntityNotFound(EntityNotFoundException ex) {
		ModelAndView mav = new ModelAndView("myerror"); // myerror.html 뷰이름
		mav.addObject("errorMessage", ex.getMessage());
		return mav;
	}

	// (3) 그 외의 예외 처리
	@ExceptionHandler(Exception.class)
	public ModelAndView handleOtherExceptions(Exception ex) {
		ModelAndView mav = new ModelAndView("myerror"); // myerror.html 뷰이름
		mav.addObject("errorMessage", "알 수 없는 오류야 :" + ex.getMessage());
		return mav;
	}
}
