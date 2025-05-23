package com.ui.pages;

import com.constants.Env;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.JsonUtility;
import com.utility.LoggerUtility;

public final class HomePage extends BrowserUtility 
{	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	private static final By SIGN_IN_LINK_LOCATOR = By.cssSelector("div[class='nav']>div>div>nav>div:first-child");
	
	public HomePage(WebDriver lambdaDriver) 
	{
		super(lambdaDriver);
		
	    goToWebsite(JsonUtility.readJson(Env.QA).getUrl());
	
	}
	
	public HomePage(Browser browserName, boolean isHeadless) 
	{
		super(browserName,isHeadless);
		
	    goToWebsite(JsonUtility.readJson(Env.QA).getUrl());
	
	}
	
	public LoginPage goToLoginPage()
	{
		logger.info("Trying to perform click to go to sign in page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		
		LoginPage loginPage = new LoginPage(getDriver());
		
		return loginPage;
	}

	public void quit() {
		// TODO Auto-generated method stub
		
	   getDriver().quit();
	}

}
