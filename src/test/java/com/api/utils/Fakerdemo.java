package com.api.utils;

import java.util.Locale;

import com.github.javafaker.Faker;

public class Fakerdemo {

	public static void main(String[] args) {
		// generate fake test data
		Locale localname=new Locale("en-IND");
		Faker faker=new Faker(localname);
		String firstname=faker.name().firstName();
		System.out.println(firstname);
		System.out.println(faker.address().city());
		System.out.println(faker.number().digits(10));

	}

}
