package com.api.tests;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UserDetailsAPITest {

	@Test
	public void UserDetailsTest() {
		
		Header headerobj=new Header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NCwiZmlyc3RfbmFtZSI6ImZkIiwibGFzdF9uYW1lIjoiZmQiLCJsb2dpbl9pZCI6ImlhbWZkIiwibW9iaWxlX251bWJlciI6Ijg4OTk3NzY2NTUiLCJlbWFpbF9pZCI6Im1hcmtAZ21haWwuY29tIiwicGFzc3dvcmQiOiI1ZjRkY2MzYjVhYTc2NWQ2MWQ4MzI3ZGViODgyY2Y5OSIsInJlc2V0X3Bhc3N3b3JkX2RhdGUiOm51bGwsImxvY2tfc3RhdHVzIjowLCJpc19hY3RpdmUiOjEsIm1zdF9yb2xlX2lkIjo1LCJtc3Rfc2VydmljZV9sb2NhdGlvbl9pZCI6MSwiY3JlYXRlZF9hdCI6IjIwMjEtMTEtMDNUMDg6MDY6MjMuMDAwWiIsIm1vZGlmaWVkX2F0IjoiMjAyMS0xMS0wM1QwODowNjoyMy4wMDBaIiwicm9sZV9uYW1lIjoiRnJvbnREZXNrIiwic2VydmljZV9sb2NhdGlvbiI6IlNlcnZpY2UgQ2VudGVyIEEiLCJpYXQiOjE3Njk0NDc2OTd9.MNHE217qEetupT9Y3cq30w76QOs3xJl0besNf2LTqyo");
		
	Response response=	given()
		      .baseUri("http://64.227.160.186:9000/v1")
		      .contentType(ContentType.JSON)
		      .header(headerobj)
		      .log().uri().log().headers().log().method()
		.when() 
		      .get("/userdetails")
		.then()
		      .log().status()
		      .time(Matchers.lessThan(10000L))
		      .statusCode(200)
		      .body("message", Matchers.equalTo("Success")).body("data.id",Matchers.equalTo(4))
		      .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("responseSchema/userdetails.json"))
		      .extract().response();
		       
		   JsonPath obj=response.jsonPath();
		  String fname= obj.getString("first_name");
		      
		
		
	
	
	
}
	
}
