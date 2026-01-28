package com.api.tests;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.constants.Role;
import com.api.utils.AuthTokenProvider;
import com.api.utils.ConfigManager;
import com.api.utils.SpecUtil;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UserDetailsAPITest {

	@Test
	public void UserDetailsTest() {

		Header headerobj = new Header("Authorization",AuthTokenProvider.getToken(Role.FD));

		Response response = given().spec(SpecUtil.requestspecWithAUth(Role.FD))
			.when()
				.get("/userdetails")
			.then().log().status().time(Matchers.lessThan(10000L)).statusCode(200)
				.body("message", Matchers.equalTo("Success")).log().body()
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("responseSchema/userdetails.json")).extract()
				.response();

		JsonPath obj = response.jsonPath();
		String fname = obj.getString("first_name");

	}

}
