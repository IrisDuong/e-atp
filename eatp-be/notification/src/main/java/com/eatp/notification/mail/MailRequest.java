package com.eatp.notification.mail;

public record MailRequest(String from, String to,String subject,String templateName, java.util.Map<String, Object> variables){
}
