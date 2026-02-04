package com.eatp.apigateway.config.security;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtReactiveAuthenticationManager;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;
import org.springframework.security.web.server.authorization.ServerAccessDeniedHandler;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.eatp.common.dto.response.ApiResponse;
import com.eatp.common.exception.BusinessException;
import com.eatp.common.utils.CookieUtils;
import com.eatp.common.utils.DateUtils;
import com.eatp.common.utils.SystemUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.util.StandardCharset;

import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

	private final Oauth2AuthenticationSuccessHandler authenSuccessHandler;
	
	@Value("${url.auth-server}")
	private String authServerURL;
	
	public SecurityConfig(Oauth2AuthenticationSuccessHandler authenSuccessHandler) {
		super();
		this.authenSuccessHandler = authenSuccessHandler;
	}

	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
		http.csrf(ServerHttpSecurity.CsrfSpec::disable)
			.authorizeExchange(authExchange->authExchange
					.pathMatchers("/login/**","/oauth2/**","/static/**","/authen/**","/in-user/**").permitAll()
					.anyExchange().authenticated()
			)
			.oauth2Login(oauth2Login->oauth2Login.authenticationSuccessHandler(authenSuccessHandler))
			.formLogin(ServerHttpSecurity.FormLoginSpec::disable);
		return http.build();
	}
}
