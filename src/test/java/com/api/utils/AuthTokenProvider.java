package com.api.utils;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;

import com.api.constants.Role;
import com.api.pojos.UserCreds;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AuthTokenProvider {

	private AuthTokenProvider() {
    // obj creation is prevented..
	}

	public static String getToken(Role role) {

		// Extract token for indviual role and pass to UsedetailsAPITest

		UserCreds user=null;
		
		if(role==Role.FD) {
			user=new UserCreds("iamfd", "password");
		}
		else if(role==Role.SUP) {
			user=new UserCreds("iamsup", "password");
		}
		else if(role==Role.ENG) {
			user=new UserCreds("iameng", "password");
		}
		else if(role==Role.QC){
			user=new UserCreds("iamqc", "password");
		}
		
		Response res = given().baseUri(ConfigManager.getProperty("BASE_URI")).contentType(ContentType.JSON)
				.body(user).log().method().log().uri()
			.when()
			    .post("/login")
			.then()
				.log().ifValidationFails()
				.log()
				.body().log().status().statusCode(200).body("message",Matchers.equalTo("Success")).extract().response();

		JsonPath json = res.jsonPath();
		String token = json.getString("data.token");

		System.out.println("TOken is- " + token);
		return token;

	}

}
