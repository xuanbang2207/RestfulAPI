package com.home.service;

import javax.mail.MessagingException;

import com.home.model.MailInfo;

public interface MailerService {

	void send(String to, String subject, String body) throws MessagingException;

	void send(MailInfo mail) throws MessagingException;
	
	void push(MailInfo mail) throws MessagingException;

	void push(String to, String subject, String body) throws MessagingException;

}
