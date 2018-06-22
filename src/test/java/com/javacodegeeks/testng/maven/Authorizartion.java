package com.javacodegeeks.testng.maven;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;


public class Authorizartion {
	@Test
	public void checkAuthentication() {
		Response response = RestAssured.get("http://restapi.demoqa.com/authentication/CheckForAuthentication");
		int code=response.getStatusCode();
		ResponseBody<?> body=response.getBody();
		System.out.println("Repsonse of request"+body.asString());
		System.out.println("Status code is "+code);	
	}

}
