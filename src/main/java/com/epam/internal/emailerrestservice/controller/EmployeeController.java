package com.epam.internal.emailerrestservice.controller;

import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.internal.emailerrestservice.entity.Employee;
import com.epam.internal.emailerrestservice.entity.Fulfilment;
import com.epam.internal.emailerrestservice.services.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    
    @PostMapping("/webhook")
    public Fulfilment webhookInterceptor(@RequestBody Object obj){
    	ObjectMapper mapper = new ObjectMapper();
    	Fulfilment response = new Fulfilment();
    	try {
			String output = mapper.writeValueAsString(obj);
			
			System.out.println("From webhook inputs"+output);
			JSONObject jsonObj = new JSONObject((Map) obj);
			Map queryResult = (Map)jsonObj.get("queryResult");
			String employeeId = (String) ((Map)queryResult.get("parameters")).get("Employee");
			System.out.println(" Employee Id "+employeeId);
			
			Employee responseEmp = getEmployee(employeeId);
			
			if(null != responseEmp) {
				response.setFulfillmentText(responseEmp.toString());
				response.setSource("");
			}else {
				response.setFulfillmentText("Sorry, no information about the employee "+employeeId+" is available.");
			}
			
			 
			
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return response;
    	
    }


}
