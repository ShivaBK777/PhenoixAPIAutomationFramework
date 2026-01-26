package com.api.tests;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.pojos.UserCreds;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;

public class LoginAPITest {

	
	@Test
	public void LoginAPITest() {
		
		File newfile=new File("src/test/resources/requestPayload/loginAPIpayload.json");
		
	 // Jatin has used pojo   UserCreds userobj=new UserCreds("iamfd","password");
		
	Response response=given()
		.baseUri("http://64.227.160.186:9000/v1")
		.contentType(ContentType.JSON)
		.body(newfile)
		.log().uri().log().headers().log().body().log().method()
	.when()
	    .post("/login")
	    
	 .then()
	 //   .log().ifValidationFails()
	    .log().status().log().body()
	    .statusCode(200)
	    .body("message",Matchers.equalTo("Success"))
	    .time(Matchers.lessThan(10000L))
	    .extract().response();
	   
	    
	}
	
	
}
