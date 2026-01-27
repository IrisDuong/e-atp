package com.eatp.usermgt.sysuser.service.grpc;

import org.springframework.stereotype.Service;

import com.eatp.grpc.usermgt.proto.SysUserProtoRequest;
import com.eatp.grpc.usermgt.proto.SysUserProtoResponse;
import com.eatp.grpc.usermgt.proto.SysUserProtoServiceGrpc.SysUserProtoServiceImplBase;
import com.eatp.usermgt.sysuser.dto.SysUserDtoRequest;
import com.eatp.usermgt.sysuser.service.SysUserService;

import io.grpc.stub.StreamObserver;

@Service
public class SysUserGrpcServiceImpl extends SysUserProtoServiceImplBase{

	private final SysUserService sysUserService;
	
	public SysUserGrpcServiceImpl(SysUserService sysUserService) {
		super();
		this.sysUserService = sysUserService;
	}

	@Override
	public void createSysUserProto(SysUserProtoRequest request, StreamObserver<SysUserProtoResponse> responseObserver) {
		SysUserDtoRequest userDtoRequest = SysUserDtoRequest.builder()
				.userName(request.getUserName())
				.password(request.getHashedPassword())
				.email(request.getEmail())
				.firstName(request.getFirstName())
				.lastName(request.getLastName())
				.phoneNo(request.getPhoneNo())
				.roleNo(request.getRoleNo())
				.avatarUrl(request.getAvatarUrl())
				.sub(request.getSub())
				.active(Boolean.TRUE)
				.deletable(Boolean.FALSE)
				.lockedTimes(0)
				.build();
		sysUserService.createNewUser(userDtoRequest);
		
		SysUserProtoResponse response = SysUserProtoResponse.newBuilder()
				.setUserName(userDtoRequest.getUserName())
				.setEmail(userDtoRequest.getEmail())
				.setRoleNo(userDtoRequest.getRoleNo())
				.setCreated(true)
				.build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
}
