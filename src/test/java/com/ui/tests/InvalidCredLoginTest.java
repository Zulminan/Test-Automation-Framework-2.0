package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;
import com.utility.LoggerUtility;


@Listeners({com.listeners.TestListener.class})
public class InvalidCredLoginTest extends TestBase
{
	//NOTE---@BeforeMethod we have moved to TestBase class
	
	Logger logger = LoggerUtility.getLogger(getClass());
	
	private static final String INVALID_EMAIL_ADDRESS = "akki@gmail.com";
	
	private static final String INVALID_PASSWORD = "qwerty1234!";

	
	@Test(description="Verifies if the proper error message is shown for the user when they enter invalid credentials",
			groups= {"e2e","sanity,smoke"}
			)
	public void loginTest() 
	{
		
		assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD).getErorMessage()
				, "Authentication failed.");
		

	}


}
