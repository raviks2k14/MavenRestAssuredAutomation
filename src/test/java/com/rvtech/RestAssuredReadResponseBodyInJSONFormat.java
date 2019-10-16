package com.rvtech;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssuredReadResponseBodyInJSONFormat {

	@Test
	public void restAssuredReadResponseBodyJSONFormat() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		RequestSpecification request = RestAssured.given();

		Response response = request.request(Method.GET, "/Bangalore");

		JsonPath jsonPathEvaluator = response.jsonPath();

		String city = jsonPathEvaluator.get("City");

		// Validate the response
		Assert.assertEquals(city, "Bangalore",
				"Correct city name received in the Response");

		// Let us print the city variable to see what we got
		System.out.println("City received from Response "
				+ jsonPathEvaluator.get("City"));

		// Print the temperature node
		System.out.println("Temperature received from Response "
				+ jsonPathEvaluator.get("Temperature"));

		// Print the humidity node
		System.out.println("Humidity received from Response "
				+ jsonPathEvaluator.get("Humidity"));

		// Print weather description
		System.out.println("Weather description received from Response "
				+ jsonPathEvaluator.get("Weather"));

		// Print Wind Speed
		System.out.println("WindSpeed received from Response "
				+ jsonPathEvaluator.get("WindSpeed"));

		// Print Wind Direction Degree
		System.out.println("WindDirectionDegree received from Response "
				+ jsonPathEvaluator.get("WindDirectionDegree"));

	}

}
