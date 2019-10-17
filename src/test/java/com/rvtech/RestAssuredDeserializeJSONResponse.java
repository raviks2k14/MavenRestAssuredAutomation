package com.rvtech;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class RestAssuredDeserializeJSONResponse {
	@SuppressWarnings("unchecked")
	@Test
	public void deserializeJSONResponse() {
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";

		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "abc");
		requestParams.put("LastName", "abc");
		requestParams.put("UserName", "abc001");
		requestParams.put("Password", "abc001");
		requestParams.put("Email", "abc001@gmail.com");

		request.body(requestParams.toJSONString());

		Response response = request.post("/register");

		ResponseBody responseBody = response.body();

		System.out.println("Response Body :" + responseBody.asString());

		if (response.getStatusCode() == 201) {
			RegistrationSuccessResponse successResponseClassInstance = responseBody
					.as(RegistrationSuccessResponse.class);

			System.out
					.println("Success Code (successResponseClassInstance.getSuccessCode()):"
							+ successResponseClassInstance.getSuccessCode());

			System.out
					.println("Success Message (successResponseClassInstance.getMessage()):"
							+ successResponseClassInstance.getMessage());
		} else if (response.getStatusCode() == 200) {
			RegistrationFailureResponse failureResponseClassInstance = responseBody
					.as(RegistrationFailureResponse.class);

			System.out
					.println("Failure Id (failureResponseClassInstance.getFaultId()):"
							+ failureResponseClassInstance.getFaultId());

			System.out
					.println("Failure Message (failureResponseClassInstance.getFault()):"
							+ failureResponseClassInstance.getFault());
		}

	}
}
