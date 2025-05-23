package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;


@Listeners({com.listeners.TestListener.class})
public class LoginTest extends TestBase
{
	//NOTE---@BeforeMethod we have moved to TestBase class

	
	@Test(description="Verifies if the valid user is able to login to application.",groups= {"e2e","sanity"},
			dataProviderClass =com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestDataProvider"
			)
	public void loginTest(User user) 
	{
		
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Akki Akki"); ;
		

	}
	
	
	@Test(description="Verifies if the valid user is able to login to application.",groups= {"e2e","sanity"},
			dataProviderClass =com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginCsvTestDataProvider",enabled=false)
	public void csvloginTest(User user) 
	{
		
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Akki Akki"); ;
		

	}
	
	@Test(description="Verifies if the valid user is able to login to application.",groups= {"e2e","sanity"},
			dataProviderClass =com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestExcelDataProvider"
			,retryAnalyzer = com.listeners.MyRetryAnalyzer.class,enabled=false)
	public void excelloginTest(User user) 
	{
		
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Akki Akki"); ;
		

	}


}
