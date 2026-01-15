package com.eatp.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class GatewayConfig {
	
	@Bean
	public WebClient.Builder webBuilder(){
		return WebClient.builder();
	}

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("AUTH-SERVER", r->r
						.path("/auth-server/**")
						.filters(f->f.stripPrefix(1))
						.uri("lb://auth-server"))
				.route("SETTING-MGT", r->r
						.path("/setting-mgt/**")
						.filters(f->f.stripPrefix(1))
						.uri("lb://setting-mgt")
				)
				.build();
				
	}
}
