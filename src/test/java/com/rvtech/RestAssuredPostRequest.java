package com.rvtech;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssuredPostRequest {
	
	@SuppressWarnings("unchecked")
	@Test
	public void postRequest(){
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender");
		requestParams.put("LastName", "Singh");
		requestParams.put("UserName", "simpleuser001");
		requestParams.put("Password", "password1");
		requestParams.put("Email", "someuser@gmail.com");
		
		request.body(requestParams.toJSONString());
		
		Response response = request.post("/register");
		
		System.out.println("RESPONSE : "+response);
		
		int statusCode = response.getStatusCode();
		
		System.out.println("The status code is : "+statusCode);
		
		Assert.assertEquals(statusCode, 200);
		
		String statusLine = response.getStatusLine();
		
		System.out.println("The status line is : "+statusLine);
		
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		Headers headers = response.getHeaders();
		
		for(Header header : headers){
			System.out.println(header.getName()+", "+header.getValue());
		}
		
	}

}
