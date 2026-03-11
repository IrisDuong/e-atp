package com.eatp.common.exception;

import com.eatp.common.utils.DateUtils;

public abstract class BaseException extends RuntimeException{

	protected int code;
	
	protected BaseException(String message,int code) {
		super(message);
		this.code = code;
	}
	
	protected abstract int getHttpCode();
}
