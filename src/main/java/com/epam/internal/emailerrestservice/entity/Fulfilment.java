package com.epam.internal.emailerrestservice.entity;

import java.util.ArrayList;

public class Fulfilment {
 private String fulfillmentText;
 ArrayList < Object > fulfillmentMessages = new ArrayList < Object > ();
 private String source;
 Payload PayloadObject;
 ArrayList < Object > outputContexts = new ArrayList < Object > ();
 FollowupEventInput FollowupEventInputObject;


 // Getter Methods 

 public String getFulfillmentText() {
  return fulfillmentText;
 }

 public String getSource() {
  return source;
 }

 public Payload getPayload() {
  return PayloadObject;
 }

 public FollowupEventInput getFollowupEventInput() {
  return FollowupEventInputObject;
 }

 // Setter Methods 

 public void setFulfillmentText(String fulfillmentText) {
  this.fulfillmentText = fulfillmentText;
 }

 public void setSource(String source) {
  this.source = source;
 }

 public void setPayload(Payload payloadObject) {
  this.PayloadObject = payloadObject;
 }

 public void setFollowupEventInput(FollowupEventInput followupEventInputObject) {
  this.FollowupEventInputObject = followupEventInputObject;
 }
}
class FollowupEventInput {
 private String name;
 private String languageCode;
 Parameters ParametersObject;


 // Getter Methods 

 public String getName() {
  return name;
 }

 public String getLanguageCode() {
  return languageCode;
 }

 public Parameters getParameters() {
  return ParametersObject;
 }

 // Setter Methods 

 public void setName(String name) {
  this.name = name;
 }

 public void setLanguageCode(String languageCode) {
  this.languageCode = languageCode;
 }

 public void setParameters(Parameters parametersObject) {
  this.ParametersObject = parametersObject;
 }
}
class Parameters {
 private String param;


 // Getter Methods 

 public String getParam() {
  return param;
 }

 // Setter Methods 

 public void setParam(String param) {
  this.param = param;
 }
}
class Payload {
 Google GoogleObject;
 Facebook FacebookObject;
 Slack SlackObject;


 // Getter Methods 

 public Google getGoogle() {
  return GoogleObject;
 }

 public Facebook getFacebook() {
  return FacebookObject;
 }

 public Slack getSlack() {
  return SlackObject;
 }

 // Setter Methods 

 public void setGoogle(Google googleObject) {
  this.GoogleObject = googleObject;
 }

 public void setFacebook(Facebook facebookObject) {
  this.FacebookObject = facebookObject;
 }

 public void setSlack(Slack slackObject) {
  this.SlackObject = slackObject;
 }
}
class Slack {
 private String text;


 // Getter Methods 

 public String getText() {
  return text;
 }

 // Setter Methods 

 public void setText(String text) {
  this.text = text;
 }
}
class Facebook {
 private String text;


 // Getter Methods 

 public String getText() {
  return text;
 }

 // Setter Methods 

 public void setText(String text) {
  this.text = text;
 }
}
class Google {
 private boolean expectUserResponse;
 RichResponse RichResponseObject;


 // Getter Methods 

 public boolean getExpectUserResponse() {
  return expectUserResponse;
 }

 public RichResponse getRichResponse() {
  return RichResponseObject;
 }

 // Setter Methods 

 public void setExpectUserResponse(boolean expectUserResponse) {
  this.expectUserResponse = expectUserResponse;
 }

 public void setRichResponse(RichResponse richResponseObject) {
  this.RichResponseObject = richResponseObject;
 }
}
class RichResponse {
 ArrayList < Object > items = new ArrayList < Object > ();


 // Getter Methods 



 // Setter Methods 


}