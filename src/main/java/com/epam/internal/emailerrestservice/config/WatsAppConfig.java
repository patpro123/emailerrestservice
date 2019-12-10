package com.epam.internal.emailerrestservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("watsapp")
public class WatsAppConfig {

	public WatsAppConfig() {
		// TODO Auto-generated constructor stub
	}
	
	private String account_sid;
	private String auth_token;
	private String from_number;
	private String to_security;
	private boolean enable_messaging;
	
	public boolean isEnable_messaging() {
		return enable_messaging;
	}
	public void setEnable_messaging(boolean enable_messaging) {
		this.enable_messaging = enable_messaging;
	}
	@Override
	public String toString() {
		return "WatsAppConfig [account_sid=" + account_sid + ", auth_token=" + auth_token + ", from_number="
				+ from_number + ", to_security=" + to_security + ", enable_messaging=" + enable_messaging
				+ ", to_broadcast_numbers=" + to_broadcast_numbers + "]";
	}

	private String to_broadcast_numbers;

	public String getAccount_sid() {
		return account_sid;
	}
	public void setAccount_sid(String account_sid) {
		this.account_sid = account_sid;
	}
	public String getAuth_token() {
		return auth_token;
	}
	public void setAuth_token(String auth_token) {
		this.auth_token = auth_token;
	}
	public String getFrom_number() {
		return from_number;
	}
	public void setFrom_number(String from_number) {
		this.from_number = from_number;
	}
	public String getTo_security() {
		return to_security;
	}
	public void setTo_security(String to_security) {
		this.to_security = to_security;
	}
	public String getTo_broadcast_numbers() {
		return to_broadcast_numbers;
	}
	public void setTo_broadcast_numbers(String to_broadcast_numbers) {
		this.to_broadcast_numbers = to_broadcast_numbers;
	}
	
	

}
