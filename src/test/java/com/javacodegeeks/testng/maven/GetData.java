package com.javacodegeeks.testng.maven;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;


public class GetData {
	@Test
	public void testResponseCode(){
		
		Response response = RestAssured.get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad");
		
		int code = response.statusCode();
		System.out.println("Status code is "+code);
		
		Assert.assertEquals(code, 200);
	}
	@Test
	public void testBody(){
		
		String data = RestAssured.get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad").asString();		
		System.out.println("Response Body "+data);		
		
	}
}
