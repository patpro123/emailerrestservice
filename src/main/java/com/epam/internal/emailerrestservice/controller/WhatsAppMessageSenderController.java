package com.epam.internal.emailerrestservice.controller;

import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.internal.emailerrestservice.config.WatsAppConfig;
import com.epam.internal.emailerrestservice.entity.Email;
import com.epam.internal.emailerrestservice.entity.Employee;
import com.epam.internal.emailerrestservice.entity.Fulfilment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@RestController
public class WhatsAppMessageSenderController {

	@Autowired
	WatsAppConfig watsAppConfig;
	
	public WhatsAppMessageSenderController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/sendMessage")
    public Fulfilment webhookInterceptor(@RequestBody Object obj){
    	ObjectMapper mapper = new ObjectMapper();
    	Fulfilment response = new Fulfilment();
    	try {
			String output = mapper.writeValueAsString(obj);
			
			System.out.println("From webhook inputs"+output);
			JSONObject jsonObj = new JSONObject((Map) obj);
			Map queryResult = (Map)jsonObj.get("queryResult");
			Map parameters = (Map)queryResult.get("parameters");
			String sendMessageConfirm = (String) parameters.get("sendMessage");
			System.out.println(" sendMessageConfirm "+sendMessageConfirm);
			
			if("Y".equalsIgnoreCase(sendMessageConfirm)) {
				//send a watsapp message
				String building = (String) parameters.get("Building");
				String zone = (String) parameters.get("Zone");
				String door = (String) parameters.get("Door");
				String securityMessage = "Please close doors "+door+" in zone:"+zone+" of building "+building;
				
				Twilio.init(watsAppConfig.getAccount_sid(), watsAppConfig.getAuth_token());
		        Message message = Message.creator(
		                new com.twilio.type.PhoneNumber("whatsapp:"+watsAppConfig.getTo_security()),
		                new com.twilio.type.PhoneNumber("whatsapp:"+watsAppConfig.getFrom_number()),
		                securityMessage)
		            .create();
		        System.out.println(" Message to security sent succesfully - id:"+message.getSid());
				
			}else {
				response.setFulfillmentText("Please confirm message send to broadcast");
			}
			
			 
			
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return response;
    	
    }


}
