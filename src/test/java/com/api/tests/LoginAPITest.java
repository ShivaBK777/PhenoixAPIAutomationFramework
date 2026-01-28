package com.api.tests;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.pojos.UserCreds;
import com.api.utils.ConfigManager;
import com.api.utils.SpecUtil;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;

public class LoginAPITest {

	@Test
	public void LoginAPITest() {

	//	File newfile = new File("src/test/resources/requestPayload/loginAPIpayload.json");

		// Jatin has used pojo 
		UserCreds userobj=new UserCreds("iamfd","password");

		Response response = given().spec(SpecUtil.requestspec(userobj))
				.log().uri().log().headers().log().body().log().method()
				
			.when().post("/login")
            .then()
				// .log().ifValidationFails()
            .spec(SpecUtil.responseSpecification())
				.body("message", Matchers.equalTo("Success"))
				.time(Matchers.lessThan(10000L)).extract().response();

	}

}
