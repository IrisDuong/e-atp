package com.eatp.apigateway.config.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

	private final Oauth2AuthenticationSuccessHandler authenSuccessHandler;
	
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
