package com.javacodegeeks.testng.maven;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
//testing a simple response containing some JSON data here 
public class getSingleUserGherkin {
	@Test
	public void testGetSingleUser_Json() {
	given().
	  expect().
	    statusCode(200).
	    body(
	      "email", equalTo("test@hascode.com"),
	      "firstName", equalTo("Tim"),
	      "lastName", equalTo("Testerman"),
	      "id", equalTo("1")).
	    when().
	    get("http://localhost:9999/rest-assured-example/service/single-user");  	
	
	}
	//validate returned XML
	@Test
	public void testGetSingleUser_XML() {
	given().
	  expect().
	    statusCode(200).
	    body(
	      "user.email", equalTo("test@hascode.com"),
	      "user.firstName", equalTo("Tim"),
	      "user.lastName", equalTo("Testerman"),
	      "user.id", equalTo("1")).
	    when().	    
	    get("http://localhost:9999/rest-assured-example/service/single-user/xml");	
	
	}
}
