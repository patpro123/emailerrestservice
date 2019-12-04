package com.epam.internal.emailerrestservice.controller;

import java.io.IOException;
import java.net.URI;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.epam.internal.emailerrestservice.entity.Email;

@Controller
public class EmailController {

	public EmailController() {
		// TODO Auto-generated constructor stub
	}
	
    @Autowired
	private JavaMailSender javaMailSender;

    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public ResponseEntity<Email> sendEmail(@RequestBody Email email) {
        try {
			sendEmailWithAttachment(email);
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("Successfully sent email");
		URI location = ServletUriComponentsBuilder
    			.fromCurrentRequest()
    			.path("/{toAddress}")
    			.buildAndExpand(email.getToEmailAddress())
    			.toUri();
    		return ResponseEntity.created(location).build();
        
    }
    
	private void sendEmailWithAttachment(Email email) throws MessagingException, IOException {

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

	}


}
