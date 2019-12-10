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
	
	private String to_broadcast_num1;
	private String to_broadcast_num2;
	private String to_broadcast_num3;
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
	public String getTo_broadcast_num1() {
		return to_broadcast_num1;
	}
	public void setTo_broadcast_num1(String to_broadcast_num1) {
		this.to_broadcast_num1 = to_broadcast_num1;
	}
	public String getTo_broadcast_num2() {
		return to_broadcast_num2;
	}
	public void setTo_broadcast_num2(String to_broadcast_num2) {
		this.to_broadcast_num2 = to_broadcast_num2;
	}
	

}
