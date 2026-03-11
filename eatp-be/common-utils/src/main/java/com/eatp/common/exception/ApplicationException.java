package com.eatp.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.eatp.common.dto.response.ErrorResponse;
import com.eatp.common.utils.DateUtils;

@RestControllerAdvice
public class ApplicationException {

	public static ResponseEntity<ErrorResponse> doResponse(BaseException ex){
		ErrorResponse errorResponse = new ErrorResponse(ex.getHttpCode(), ex.getMessage(), DateUtils.getNowAsString(true));
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.valueOf(ex.getHttpCode()));
	}
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException ex){
		return doResponse(ex);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNotFound(NotFoundException ex){
		return doResponse(ex);
	}

	@ExceptionHandler(InternalServerErrorException.class)
	public ResponseEntity<ErrorResponse> handleNotFound(InternalServerErrorException ex){
		return doResponse(ex);
	}
}
