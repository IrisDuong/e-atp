package com.eatp.settingmgt.auditing;

import java.security.Principal;
import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component(value = "auditorAware")
public class BaseAuditingImpl implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		OAuth2User principal = (OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return !ObjectUtils.isEmpty(principal) ? Optional.of(principal.getAttribute("mail")):Optional.empty();
	}

}
