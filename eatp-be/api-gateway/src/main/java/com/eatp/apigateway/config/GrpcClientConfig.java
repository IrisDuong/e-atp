package com.eatp.apigateway.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.eatp.grpc.usermgt.SysUserProtoServiceGrpc;
import com.eatp.grpc.usermgt.SysUserProtoServiceGrpc.SysUserProtoServiceBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@Configuration
public class GrpcClientConfig {
	
	private final DiscoveryClient discoveryClient;
	
	@Value("${GRPC_PORT_USER_MGT}")
	private int grpcPortUserMgt;

	public GrpcClientConfig(DiscoveryClient discoveryClient) {
		super();
		this.discoveryClient = discoveryClient;
	}
	
	@Bean
	public ManagedChannel userServiceChanel() {
		return ManagedChannelBuilder.forAddress("user-mgt", grpcPortUserMgt).usePlaintext().build();
	}

	@Bean
	public SysUserProtoServiceBlockingStub sysUserProtoServiceBlockingStub(ManagedChannel userServiceChanel) {
		return SysUserProtoServiceGrpc.newBlockingStub(userServiceChanel);
	}
}
