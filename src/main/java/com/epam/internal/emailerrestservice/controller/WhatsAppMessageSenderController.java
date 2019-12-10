package com.epam.internal.emailerrestservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.internal.emailerrestservice.config.WatsAppConfig;
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

	@SuppressWarnings("unchecked")
	@PostMapping("/sendMessage")
	public Fulfilment webhookInterceptor(@RequestBody Object obj){
		ObjectMapper mapper = new ObjectMapper();
		Fulfilment response = new Fulfilment();
		try {
			String output = mapper.writeValueAsString(obj);

			System.out.println("From webhook inputs"+output);
			JSONObject jsonObj = new JSONObject((Map) obj);
			Map queryResult = (Map)jsonObj.get("queryResult");
			Map intent = (Map)queryResult.get("intent");
			Map parameters = (Map)queryResult.get("parameters");
			String confirmIntent = intent.get("displayName").toString();
			System.out.println(" confirmIntent "+confirmIntent);

			if(confirmIntent.contains("confirm")) {
				//send a watsapp message
				String building = (String) parameters.get("Building");
				String zone = (String) parameters.get("Zone");
				List doorlist = (List) parameters.get("Door");
				String doors = String.join(", ", doorlist);;
				String securityMessage = "Please close doors "+doors+" in zone:"+zone+" of "+building+". Please note this message has also been broadcast to all tenants";
				System.out.println(securityMessage);
				System.out.println(watsAppConfig.toString());

				if(watsAppConfig.isEnable_messaging())Twilio.init(watsAppConfig.getAccount_sid(), "dc52c784a363c3d9a813e70bf59bdeeb");
				//send security message
				sendWatsAppMessage(securityMessage,watsAppConfig.getTo_security());

				//send broadcast message
				String broadcastMessage = "Please be informed, doors "+doors+" in zone:"+zone+" of "+building+" would be shortly closed owing to a probable security incident. More information to follow";
				List allBroadcastNumbers = Arrays.asList(watsAppConfig.getTo_broadcast_numbers().split(","));

				allBroadcastNumbers.forEach(each -> sendWatsAppMessage(broadcastMessage,each.toString()));

			}else {
				response.setFulfillmentText("Please confirm message send to broadcast");
			}




		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;

	}

	private void sendWatsAppMessage(String message,String toNumber) {
		System.out.println("toNumber"+ toNumber);

		if(watsAppConfig.isEnable_messaging()) {
			Message outMessage = Message.creator( new
					com.twilio.type.PhoneNumber("whatsapp:"+toNumber), new
					com.twilio.type.PhoneNumber("whatsapp:"+watsAppConfig.getFrom_number()),
					message) .create();
			System.out.println(" Message to security sent succesfully - id:"+outMessage.
					getSid());
		}
	}


}
