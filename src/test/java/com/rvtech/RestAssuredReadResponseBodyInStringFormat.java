package com.rvtech;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.Test;

public class RestAssuredReadResponseBodyInStringFormat {

	@Test
	public void readResponseBodyAsString() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		RequestSpecification request = RestAssured.given();

		Response response = request.request(Method.GET, "/Bangalore");

		ResponseBody responseBody = response.getBody();

		String responseString = responseBody.asString();

		System.out.println("The reponse in the string format is : "
				+ responseString);
	}

}
