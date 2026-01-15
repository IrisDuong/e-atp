package com.eatp.common.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.eatp.common.dto.response.ApiResponse;

public class ApiUtils<T> {

	public static <T> ResponseEntity<ApiResponse<T>> buildApiResponse(T data, HttpStatus httpStatus, String message){
		return new ResponseEntity<ApiResponse<T>>(new ApiResponse<T>(data, httpStatus.value(), message, DateUtils.getNowAsString(true)), httpStatus);
	}
}
