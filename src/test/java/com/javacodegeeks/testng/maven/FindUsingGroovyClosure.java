package com.javacodegeeks.testng.maven;

import java.util.Map;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class FindUsingGroovyClosure {
	@Test
	public void testFindUsingGroovyClosure() {
	  String json = RestAssured.get("http://localhost:9999/rest-assured-example/service/persons/json").asString();
	  
	  JsonPath jp = new JsonPath(json);
	  jp.setRoot("person");
	  Map<?, ?> person = jp.get("find {e -> e.email =~ /test@/}");
	  //System.out.println(person());
	  //System.out.println("Searched pattern matched for "+mailcount);
	  System.out.println("Searched Pattern email "+person.get("email"));
	  Assert.assertEquals("test@hascode.com", person.get("email"));
	  Assert.assertEquals("Tim", person.get("firstName"));
	  Assert.assertEquals("Testerman", person.get("lastName"));
	}
}
