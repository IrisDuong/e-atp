package com.eatp.usermgt.sysuser.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eatp.common.dto.response.ApiResponse;
import com.eatp.common.utils.ApiUtils;
import com.eatp.usermgt.sysuser.dto.SysUserDtoRequest;
import com.eatp.usermgt.sysuser.service.SysUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/in-user")
@RequiredArgsConstructor
public class SysUserController {

	private final SysUserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse<Void>> createNewUser(@RequestBody SysUserDtoRequest request){
		userService.createNewUser(request);
		return ApiUtils.buildApiResponse(null, HttpStatus.CREATED, "Create new user successfully");
	}
}
