package com.epam.internal.emailerrestservice.entity;

public class Employee {

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String firstName, String lastName, String employeeId, String emailAddress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeId = employeeId;
		this.emailAddress = emailAddress;
	}

	private String firstName;
	private String lastName;
	private String employeeId;
	private String emailAddress;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	@Override
	public String toString() {
	StringBuffer sb = new StringBuffer();
	sb.append("The details found are - Name: ").append(this.firstName).append(this.lastName).append(" ").append("Email Address: ").append(this.emailAddress);
	return sb.toString();
	}

}
