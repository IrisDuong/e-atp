package com.eatp.common.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends BaseException{

	public BadRequestException(String message) {
		super(message, HttpStatus.BAD_REQUEST.value());
	}

	@Override
	protected int getHttpCode() {
		return this.code;
	}

}
