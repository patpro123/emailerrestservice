package com.epam.internal.emailerrestservice.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.epam.internal.emailerrestservice.entity.Employee;
import com.epam.internal.emailerrestservice.exception.UserNotFoundException;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private static List<Employee> employeeList = Arrays.asList(
			new Employee("Parthoprotim","Mukherjee","555591","parthoprotim_mukherjee@epam.com"),
			new Employee("Biju","Nair","123456","biju_nair@epam.com"),
			new Employee("Santanu","Mukherjee","123457","santanu_mukherjee@epam.com")
			);

	public EmployeeServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Employee getEmployeeDetails(String employeeId) {
		List<Employee> emp = employeeList.stream().filter(each -> employeeId.equals(each.getEmployeeId())).collect(Collectors.toList());
		if(!emp.isEmpty()) {
			return emp.get(0);
		}
		return null;
		//throw new UserNotFoundException("ERR-001,The Employee is not present in our database.Please try again");

		
	}

}
