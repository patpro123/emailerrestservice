package com.epam.internal.emailerrestservice.services;

import com.epam.internal.emailerrestservice.entity.Employee;

public interface EmployeeService {

	public Employee getEmployeeDetails(String employeeId);
}
