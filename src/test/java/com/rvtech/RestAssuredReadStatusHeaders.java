package com.rvtech;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssuredReadStatusHeaders {
	@Test
	public void readStatusAndHeaders() {
		// Specify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();

		// Response Object
		Response response = httpRequest.request(Method.GET, "/Hyderabad");

		// Print Response body
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is : " + responseBody);

		// Print Status code
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

		// Print status line
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

		// Get individual header
		String contentType = response.getHeader("Content-Type");
		System.out.println("Header Content Type : " + contentType);
		Assert.assertEquals(contentType /* actual value */, "application/json" /*
																				 * expected
																				 * value
																				 */);

		String serverType = response.header("Server");
		Assert.assertEquals(serverType /* actual value */, "nginx/1.12.1" /*
																			 * expected
																			 * value
																			 */);

		// Reader header of a give name. In this line we will get
		// Header named Content-Encoding
		String contentEncoding = response.header("Content-Encoding");
		Assert.assertEquals(contentEncoding /* actual value */, "gzip" /*
																		 * expected
																		 * value
																		 */);

		// Get list of headers
		Headers header = response.getHeaders();

		// Printing all headers from response
		for (Header hdr : header) {
			System.out.println("Key: " + hdr.getName() + ", Value: "
					+ hdr.getValue());
		}
	}
}
