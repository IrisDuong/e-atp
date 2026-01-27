package com.eatp.apigateway.config.security;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.eatp.common.enums.UserRole;
import com.eatp.common.utils.CookieUtils;
import com.eatp.grpc.usermgt.proto.SysUserProtoRequest;
import com.eatp.grpc.usermgt.proto.SysUserProtoServiceGrpc.SysUserProtoServiceBlockingStub;

import reactor.core.publisher.Mono;

@Component
public class Oauth2AuthenticationSuccessHandler implements ServerAuthenticationSuccessHandler{

	private final ReactiveOAuth2AuthorizedClientService reactiveOAuth2AuthorizedClientService;
	private final SysUserProtoServiceBlockingStub stub;
	private final PasswordEncoder passwordEncoder;

	@Value("${url.front-end}")
	private String feURL;
	
	public Oauth2AuthenticationSuccessHandler(
			ReactiveOAuth2AuthorizedClientService reactiveOAuth2AuthorizedClientService
		   ,SysUserProtoServiceBlockingStub stub
		   ,PasswordEncoder passwordEncoder
			) {
		super();
		this.reactiveOAuth2AuthorizedClientService = reactiveOAuth2AuthorizedClientService;
		this.stub = stub;
		this.passwordEncoder = passwordEncoder;
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
					OAuth2User oAuth2User = oAuth2AuthenticationToken.getPrincipal();
					SysUserProtoRequest sysUserProtoRequest = SysUserProtoRequest.newBuilder()
							.setEmail(oAuth2User.getAttribute("email"))
							.setFirstName(oAuth2User.getAttribute("name"))
							.setAvatarUrl(oAuth2User.getAttribute("picture"))
							.setPassword(passwordEncoder.encode("12345"))
							.setActive(true)
							.setDeletable(false)
							.setLockedTimes(0)
							.setPhoneNo("078424053")
							.setSub(oAuth2User.getAttribute("sub"))
							.setUserName(oAuth2User.getAttribute("email"))
							.setRoleNo(UserRole.EMP.getRoleNo())
							.build();
					stub.createSysUserProto(sysUserProtoRequest);
					
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
