package com.javacodegeeks.testng.maven;

import org.testng.annotations.Test;
import org.junit.Assert;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

//testing a simple response containing some JSON data here 

public class getSingleUser {
	@Test
	public void GetUser() {
		Response response=RestAssured.get("http://localhost:9999/rest-assured-example/service/single-user");
		//get response body as string
		System.out.println("Response is "+response.asString());
		//get status code
		int code=response.getStatusCode();
		System.out.println("Status code is "+code);
		//get content type
		String ctype=response.contentType();
		System.out.println("content type is "+ctype);
		//get headers as list
		System.out.println("List of Headers "+response.getHeaders().asList());
		//get one of the header value
		System.out.println(response.getHeaders().getValue("Date"));
		
		// To get node values ,First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();
		System.out.println(jsonPathEvaluator.get("email"));
		System.out.println(jsonPathEvaluator.get("firstName"));
		String id=jsonPathEvaluator.get("id");
		System.out.println("id is "+id);		
		Assert.assertEquals("Correct id is displayed", "1", id);
		
		
	}

}
