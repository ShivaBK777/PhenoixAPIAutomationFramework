package com.dataproviders;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.api.utils.CSVReaderUtility;
import com.dataproviders.api.beans.UserBean;

public class DataProvidersUtils {

	
	@DataProvider(name="loginAPIDataProvider")
	public static Iterator<UserBean> loginDataProvider() {
		// DataProvider can return only these 3 formats-means return type shld be one among these 3
		// []
		// [] []
		//iterator<>--easiest use this only
		
		return CSVReaderUtility.loadCSV("testData/LoginCreds.csv",UserBean.class);
	}
	
	
	
}
