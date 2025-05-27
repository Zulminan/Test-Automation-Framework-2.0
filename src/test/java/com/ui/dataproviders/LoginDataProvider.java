package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CsvReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {

	
	@DataProvider(name="LoginTestDataProvider")
	public Iterator<User> loginDataProvider() 
	{
		FileReader fileReader=null;
		
		Gson gson = new Gson();
	
		try 
		{
			File file = new File(System.getProperty("user.dir")+"/testData/loginData.json");
			fileReader = new FileReader(file);
		} 
		
		catch (FileNotFoundException e) 
		{
			
			e.printStackTrace();
		}
		
		TestData data = gson.fromJson(fileReader, TestData.class);
		
		List<User> dataToReturn = new ArrayList<User>();
		
		
		for(User user : data.getData())
		{
			
			dataToReturn.add(user);
			
	    }
		
		return dataToReturn.iterator();
		 
	}
	
	
	@DataProvider(name="LoginTestCsvDataProvider")
	public Iterator<User> loginCsvDataProvider() 
	{
		return CsvReaderUtility.readCsvFile("loginData");
		 
	}
	
	
	@DataProvider(name="LoginTestExcelDataProvider")
	public Iterator<User> loginExcelDataProvider() 
	{
		return ExcelReaderUtility.readExcelFile("loginData");
		 
	}


}
