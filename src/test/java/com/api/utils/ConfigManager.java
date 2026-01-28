package com.api.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
	
	private static Properties prop=new Properties();
	private static String filepath=System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.properties";//File.separtor can be used instead of \\
	private static String env;
	
	static {
		// Operation of loading properties file in the memory
		//static block will be loaded only once when class is loaded in the memory
		
		env=System.getProperty("env","qa");
		// if in terminal "mvn test" is given without env it will pick this qa by default 
		env=env.toLowerCase().trim(); // if input is in uppercase which doesnt match switch-this takes care  and also spaces is taken care
	    System.out.println("Runnning tests in this environment from "+ env);
		switch(env){
		
		case "dev"-> // new style of Switch case(no break {} is required)
			filepath=System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.dev.properties";
		
		case "qa"->
			filepath=System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.qa.properties";
		
		case "uat"->
			filepath=System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.uat.properties";
		
		default->
			filepath=System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.qa.properties";
		}
		
		
		File fileobj=new File(filepath); 
		FileReader readerobj = null;
		try {
			readerobj = new FileReader(fileobj);
			prop.load(readerobj);  //loading the file
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {  //static method
		return prop.getProperty(key);
	}
	
	private ConfigManager() {
		// Private Constructor, so that object of this class cannot be created outside this class(for eg: in Testclass)
	}

}
