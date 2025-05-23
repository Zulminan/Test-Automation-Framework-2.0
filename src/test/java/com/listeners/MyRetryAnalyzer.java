package com.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JsonUtility;
import com.utility.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer
{
	//private static final int Max_NUMBER_OF_ATTEMPTS= Integer.parseInt(PropertiesUtil.readProperty(Env.DEV, "Max_NUMBER_OF_ATTEMPTS=3"));
	
	private static final int Max_NUMBER_OF_ATTEMPTS= JsonUtility.readJson(Env.QA).getMax_NUMBER_OF_ATTEMPTS();
	
	
	
	private static int currentAttempt = 1;
	
	@Override
	public boolean retry(ITestResult result) 
	{
		if(currentAttempt<=Max_NUMBER_OF_ATTEMPTS)
		{
			currentAttempt++;
			
			return true;
		}
		
		return false;
	}

	
}
