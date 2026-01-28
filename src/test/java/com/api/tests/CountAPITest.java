package com.api.tests;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.api.constants.Role;
import com.api.utils.AuthTokenProvider;
import com.api.utils.ConfigManager;

public class CountAPITest {

	
	@Test
public static void verifyCountAPITest() {
	 
	given()
	      .baseUri(ConfigManager.getProperty("BASE_URI"))
	      .header("Authorization",AuthTokenProvider.getToken(Role.FD)).log().method()
	.when()
	      .get("/dashboard/count")
	.then()  
	      .log().ifValidationFails()
	      .statusCode(200).time(lessThan(10000L))
	      .body("data.size()",equalTo(3))
	      .body("data.count",everyItem(greaterThanOrEqualTo(0)))
	      //.body("data.label",everyItem(notNullValue()));
	      // JsonSchemaValidator
	      //checking key:"abc" has these values 
	      .body("data.key", containsInAnyOrder("pending_for_delivery","created_today","pending_fst_assignment"))
	      ;
	      
	      
	      
	      
	      
}
	
}
