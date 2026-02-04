package com.eatp.settingmgt.config;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.web.BearerTokenResolver;
import org.springframework.security.web.SecurityFilterChain;

import com.eatp.common.utils.CookieUtils;
import com.eatp.common.utils.SystemUtils;

import jakarta.servlet.http.Cookie;

@Configuration
public class SecurityConfig {

	
	@Value("${url.auth-server}")
	private String authServerURL;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf(csrf->csrf.disable())
				.authorizeHttpRequests(auth->auth.anyRequest().authenticated())
				.oauth2ResourceServer(resourceServer->resourceServer
						.bearerTokenResolver(bearerTokenResolver())
						.jwt(Customizer.withDefaults())
						)
				.build();
	}

	@Bean
	public JwtDecoder jwtDecoder() {
		return NimbusJwtDecoder.withJwkSetUri(authServerURL.concat("/oauth2/jwks")).build();
	}

	@Bean
	public BearerTokenResolver bearerTokenResolver() {
		return request->{
			return  Stream.of(request.getCookies())
					.filter(c-> CookieUtils.ACCESS_TOKEN_COOKIE_NAME.equals(c.getName()))
					.map(Cookie::getValue).findFirst().orElse(null);
		};
	}
}
