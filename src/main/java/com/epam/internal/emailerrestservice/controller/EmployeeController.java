package com.epam.internal.emailerrestservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.epam.internal.emailerrestservice.entity.Employee;
import com.epam.internal.emailerrestservice.services.EmployeeService;

@RestController
public class EmployeeController {

	public EmployeeController() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private EmployeeService employeeService;
	
	
    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable(value="employeeId") String employeeId) {

        	return employeeService.getEmployeeDetails(employeeId);
    }


}
