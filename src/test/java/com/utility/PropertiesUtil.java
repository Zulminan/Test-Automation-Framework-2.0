package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {
	
	public static String readProperty(Env env, String propertyName ) 
	{
		
		Properties prop = new Properties();
		
		try 
		{
			File file = new File(System.getProperty("user.dir")+"//config//"+env+".properties");
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		} 
		
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
		return prop.getProperty(propertyName.toUpperCase());
		
		
	}

}
