package com.eatp.common.dto.response;

public record ErrorResponse(int httpCode, String message, String timestamp) {

}
