package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CsvReaderUtility {

	
	public static Iterator<User> readCsvFile(String fileName) 
	{
		FileReader fileReader=null;
		File cssvfile=null;
		CSVReader csvReader=null;
		
		String[] line=null;
		
		User userData=null;

		List<User> userList=null;
		
		try 
		{
			cssvfile = new File(System.getProperty("user.dir")+"\\testData\\"+fileName+".csv");
			
			fileReader = new FileReader(cssvfile);
			
			csvReader = new CSVReader(fileReader);
			
			csvReader.readNext();
			
			userList = new ArrayList<User>();
			
			while((line=csvReader.readNext())!=null)
			{
				userData = new User(line[0],line[1]);
				
				userList.add(userData);
			}
		} 
		
        catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
		
		catch (CsvValidationException e) 
		{
			
			e.printStackTrace();
		} 
		
		return userList.iterator();
		
	}
}
