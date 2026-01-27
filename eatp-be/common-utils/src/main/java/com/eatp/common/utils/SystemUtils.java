package com.eatp.common.utils;

import java.security.SecureRandom;

public class SystemUtils {

	public static String defaultUserPassword() {
		final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$%";
		SecureRandom random = new SecureRandom();
		StringBuilder password = new StringBuilder(10);
		for(int i = 0; i < 10;i++) {
			password.append(CHARS.charAt(random.nextInt(CHARS.length())));
		}
		return password.toString();
	}
}
