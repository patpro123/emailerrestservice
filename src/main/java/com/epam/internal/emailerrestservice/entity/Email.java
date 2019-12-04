package com.epam.internal.emailerrestservice.entity;

public class Email {

	public Email() {
		// TODO Auto-generated constructor stub
	}
	
	private String toEmailAddress;
	public String getToEmailAddress() {
		return toEmailAddress;
	}
	public void setToEmailAddress(String toEmailAddress) {
		this.toEmailAddress = toEmailAddress;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	private String subject;
	private String content;

}
