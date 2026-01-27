package com.eatp.usermgt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.eatp.usermgt.sysuser.service.grpc.SysUserGrpcServiceImpl;

import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;

@Configuration
public class GrpcServerConfig {
	
	@Bean(initMethod = "start", destroyMethod = "shutdown")
	public Server grpcServer(SysUserGrpcServiceImpl service) {
		return NettyServerBuilder.forPort(9090).addService(service).build();
	}
}
