package com.epam.internal.emailerrestservice.services;

import javax.mail.MessagingException;

import org.springframework.stereotype.Service;

import com.epam.internal.emailerrestservice.entity.Email;
@Service
public interface EmailService {

	public String sendEmail(Email email) throws MessagingException;
}
