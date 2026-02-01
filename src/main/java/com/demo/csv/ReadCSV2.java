package com.demo.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

public class ReadCSV2 {

	public static void main(String[] args) {
		// Java does not have in-built csv file read method.hence open csv library is added
		
		File file=new File(System.getProperty("user.dir")+"\\src\\main\\resources\\testData\\LoginCreds.csv");
		FileReader fr;CSVReader csvreader=null;
		try {
			fr=new FileReader(file); csvreader=new CSVReader(fr);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		CsvToBean<UserCredsPOJO> csvToBean=new CsvToBeanBuilder(csvreader)
				                           .withType(UserCredsPOJO.class)
				                           .withIgnoreEmptyLine(true)
				                           .build();
		
		List<UserCredsPOJO> userlist=csvToBean.parse();
		System.out.println(userlist);
		
		

	}

}
