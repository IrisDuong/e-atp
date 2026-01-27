package com.eatp.usermgt.sysuser.service;

import com.eatp.usermgt.sysuser.dto.SysUserDtoRequest;

public interface SysUserService {

	void createNewUser(SysUserDtoRequest request);
}
