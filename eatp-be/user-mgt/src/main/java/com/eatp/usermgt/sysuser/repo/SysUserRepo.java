package com.eatp.usermgt.sysuser.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eatp.usermgt.sysuser.entity.SysUser;

public interface SysUserRepo extends JpaRepository<SysUser, String>{

	Boolean existsByUserNameAndEmailAndActiveAndDeletable(String userName,String email, Boolean active, Boolean deletable);
}
