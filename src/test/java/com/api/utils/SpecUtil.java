package com.api.utils;

import com.api.constants.Role;
import com.api.pojos.UserCreds;
import com.dataproviders.api.beans.UserBean;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecUtil {

	//utility class must be static
	
	public static RequestSpecification requestspec() {
	RequestSpecification spec=	new RequestSpecBuilder()
		.setBaseUri(ConfigManager.getProperty("BASE_URI"))
		.setContentType(ContentType.JSON)
		.log(LogDetail.BODY)    //common assertions
		.log(LogDetail.URI)
		.log(LogDetail.METHOD)
		.build();
	return spec;
	}
	
	public static RequestSpecification requestspec(UserCreds user) {
		RequestSpecification spec=	new RequestSpecBuilder()
			.setBaseUri(ConfigManager.getProperty("BASE_URI"))
			.setContentType(ContentType.JSON)     //common assertions
			.setBody(user)
			.log(LogDetail.BODY)
			.log(LogDetail.URI)
			.log(LogDetail.METHOD)
			.build();
		return spec;
		}
	
	public static RequestSpecification requestspecWithAUth(Role role) {
		RequestSpecification spec=	new RequestSpecBuilder()
			.setBaseUri(ConfigManager.getProperty("BASE_URI"))
			.setContentType(ContentType.JSON)     //common assertions
			.addHeader("Authorization",AuthTokenProvider.getToken(role))
			.log(LogDetail.BODY)
			.log(LogDetail.URI)
			.log(LogDetail.METHOD)
			.build();
		return spec;
		}
	
	
	public static ResponseSpecification responseSpecification() {
		ResponseSpecification responsespec=	new ResponseSpecBuilder()
		.expectStatusCode(200)
		.log(LogDetail.STATUS)
		.log(LogDetail.BODY)       //common assertions
		.build();
		return responsespec;
	}

	public static RequestSpecification requestspec(UserBean userbean) {
		RequestSpecification spec=	new RequestSpecBuilder()
				.setBaseUri(ConfigManager.getProperty("BASE_URI"))
				.setContentType(ContentType.JSON)     //common assertions
				.setBody(userbean)
				.log(LogDetail.BODY)
				.log(LogDetail.URI)
				.log(LogDetail.METHOD)
				.build();
			return spec;
		
	}
	
}
