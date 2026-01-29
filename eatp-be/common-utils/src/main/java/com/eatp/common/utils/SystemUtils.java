package com.eatp.common.utils;

import java.security.SecureRandom;

import com.eatp.common.enums.MailTemplate;
import com.google.protobuf.Any;
import com.google.protobuf.BoolValue;
import com.google.protobuf.Int32Value;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.StringValue;

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
	
	public static String getMailSubject(MailTemplate mailTemplate) {
		return switch(mailTemplate) {
			case NEW_USER -> "[User Management] Welcome newcommer to ATP";
			default->"[NOSUBJECT]";
		};
	}
}
