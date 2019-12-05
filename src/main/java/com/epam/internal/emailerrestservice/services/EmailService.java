package com.epam.internal.emailerrestservice.services;

import javax.mail.MessagingException;

import com.epam.internal.emailerrestservice.entity.Email;

public interface EmailService {

	public String sendEmail(Email email) throws MessagingException;
}
