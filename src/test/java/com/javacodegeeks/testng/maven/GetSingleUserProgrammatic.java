package com.javacodegeeks.testng.maven;


import org.testng.annotations.Test;
import org.junit.Assert;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

//we’re using JsonPath to programatically test the returned JSON structure..
public class GetSingleUserProgrammatic {
	@Test
	public void testGetSingleUserProgrammatic() {
	  Response res = RestAssured.get("http://localhost:9999/rest-assured-example/service/single-user");
	  Assert.assertEquals(200, res.getStatusCode());
	  String json = res.asString();
	  JsonPath jp = new JsonPath(json);
	  Assert.assertEquals("test@hascode.com", jp.get("email"));
	  Assert.assertEquals("Tim", jp.get("firstName"));
	  Assert.assertEquals("Testerman", jp.get("lastName"));
	  Assert.assertEquals("1", jp.get("id"));
	}
}
