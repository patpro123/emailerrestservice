package com.epam.internal.emailerrestservice.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.epam.internal.emailerrestservice.entity.Email;

public class EmailServiceImpl implements EmailService {
	
    @Autowired
	private JavaMailSender javaMailSender;

	public EmailServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public String sendEmail(Email email) throws MessagingException {
		MimeMessage msg = javaMailSender.createMimeMessage();

		// true = multipart message
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);

		helper.setTo(email.getToEmailAddress());

		helper.setSubject(email.getSubject());

		// default = text/plain
		//helper.setText("Check attachment for image!");

		// true = text/html
		helper.setText(email.getContent()+"<h1>Check attachment for image!</h1>", true);

		// hard coded a file path
		//FileSystemResource file = new FileSystemResource(new File("path/android.png"));

		helper.addAttachment("tomcat.png", new ClassPathResource("tomcat.png"));

		javaMailSender.send(msg);
		
		return "success";

	}

}
