package com.javacodegeeks.testng.maven;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Post_Delete_PutExample {
	@SuppressWarnings("unchecked")
	@Test(priority=0)
	public void testPost(){
		
		RequestSpecification request=RestAssured.given();
		request.header("Content-Type","application/json");
		
		JSONObject jsonobject=new JSONObject();
		jsonobject.put("FirstName", "Genny");
		jsonobject.put("LastName", "May");
		jsonobject.put("UserName", "MayGenny1");
		jsonobject.put("Password", "Henry123");
		jsonobject.put("Email", "MayGenny1@gmail.com");
		
		request.body(jsonobject.toJSONString());
		Response response= request.post("http://restapi.demoqa.com/customer/register");
		int code=response.getStatusCode();
		Assert.assertEquals(201, code);
		System.out.println("testPost method completed");
	}
	
	@Test(priority=2)
	public void testDelete(){
		
		RequestSpecification request=RestAssured.given();		
		
		Response response= request.delete("http://restapi.demoqa.com/customer/register/MayGenny1");
		int code=response.getStatusCode();
		Assert.assertEquals(200, code);		
		System.out.println("testDelete method completed");
	}
	
	@Test(priority=1)
	public void testPut(){
		
		RequestSpecification request=RestAssured.given();		
		
		Response response= request.delete("http://restapi.demoqa.com/customer/register/MayGenny1");
		int code=response.getStatusCode();
		Assert.assertEquals(200, code);	
		System.out.println("testPut method completed");
		
	}

	
}
