package com.eatp.common.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseException{

	public NotFoundException(String message) {
		super(message, HttpStatus.NOT_FOUND.value());
	}
	
	@Override
	protected int getHttpCode() {
		return this.code;
	}
}
