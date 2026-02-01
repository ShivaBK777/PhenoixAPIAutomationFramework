package com.api.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.dataproviders.UserBean;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CSVReaderUtility {

	private CSVReaderUtility() {
		//No object creation allowed
	}
	
	
	
	
	public static List loadCSV(String pathfile) {
		// Java does not have in-built csv file read method.hence open csv library is added
		
	/*	File file=new File(System.getProperty("user.dir")+"\\src\\main\\resources\\testData\\LoginCreds.csv");FileReader fr;
		try {
			fr=new FileReader(file); csvreader=new CSVReader(fr);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}  */
		InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream(pathfile);
	    InputStreamReader isr=new InputStreamReader(is);
		CSVReader csvreader=new CSVReader(isr);
		
		
		
		CsvToBean<UserBean> csvToBean=new CsvToBeanBuilder(csvreader)
				                           .withType(UserBean.class)
				                           .withIgnoreEmptyLine(true)
				                           .build();
		
		List<UserBean> userlist=csvToBean.parse();
		System.out.println(userlist);
		return userlist;
	
	}
}
