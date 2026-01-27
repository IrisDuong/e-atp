package com.eatp.apigateway.config;

import java.util.List;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.eatp.grpc.usermgt.proto.SysUserProtoServiceGrpc;
import com.eatp.grpc.usermgt.proto.SysUserProtoServiceGrpc.SysUserProtoServiceBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@Configuration
public class GrpcClientConfig {
	private final DiscoveryClient discoveryClient;

	public GrpcClientConfig(DiscoveryClient discoveryClient) {
		super();
		this.discoveryClient = discoveryClient;
	}
	
	@Bean
	public ManagedChannel userServiceChanel() {
		List<ServiceInstance> serviceInstances = discoveryClient.getInstances("user-mgt");
		if(serviceInstances.isEmpty())
			throw new IllegalStateException("No instance of user-management-service");
		return ManagedChannelBuilder.forAddress(serviceInstances.get(0).getHost(), 9090).usePlaintext().build();
	}

	@Bean
	public SysUserProtoServiceBlockingStub stub(ManagedChannel userServiceChanel) {
		return SysUserProtoServiceGrpc.newBlockingStub(userServiceChanel);
	}
}
