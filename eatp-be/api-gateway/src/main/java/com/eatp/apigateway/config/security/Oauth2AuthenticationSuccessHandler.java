package com.eatp.apigateway.config.security;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.eatp.common.utils.CookieUtils;

import reactor.core.publisher.Mono;

@Component
public class Oauth2AuthenticationSuccessHandler implements ServerAuthenticationSuccessHandler{

	private final ReactiveOAuth2AuthorizedClientService reactiveOAuth2AuthorizedClientService;
	
	
	private final String feURL = "http://localhost:3000";
	
	public Oauth2AuthenticationSuccessHandler(
			ReactiveOAuth2AuthorizedClientService reactiveOAuth2AuthorizedClientService) {
		super();
		this.reactiveOAuth2AuthorizedClientService = reactiveOAuth2AuthorizedClientService;
	}


	@Override
	public Mono<Void> onAuthenticationSuccess(WebFilterExchange webFilterExchange, Authentication authentication) {
		try {
		OAuth2AuthenticationToken oAuth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;
		String principalName = authentication.getName();
		String clientId = oAuth2AuthenticationToken.getAuthorizedClientRegistrationId();
		ServerWebExchange webExchange = webFilterExchange.getExchange();
		ServerHttpResponse response = webExchange.getResponse();
		
		return reactiveOAuth2AuthorizedClientService.loadAuthorizedClient(clientId, principalName)
				.flatMap(oauth2AuthorizedClient->{
					OAuth2AccessToken accessToken = oauth2AuthorizedClient.getAccessToken();
					String accessTokenValue = accessToken.getTokenValue();
					CookieUtils.setReactiveCookie(response, CookieUtils.ACCESS_TOKEN_COOKIE_NAME, accessTokenValue, 1200000);
					
					response.getHeaders().setLocation(URI.create(feURL));
					response.setStatusCode(HttpStatus.FOUND);
					return response.setComplete();
				});
		} catch (Exception e) {
			e.printStackTrace();
			return Mono.empty();
		}
	}

}
