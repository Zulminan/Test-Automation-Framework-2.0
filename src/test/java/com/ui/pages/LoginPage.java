package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {
	
	private static final By EMAIL_ADDRESS_TEXTBOX_LOCATOR = By.cssSelector("form[id='login_form']>div>div:first-child>input");
	
	private static final By PASSWORD_TEXTBOX_LOCATOR = By.cssSelector("form[id='login_form']>div>div:nth-child(2)>input");

	private static final By SIGN_IN_BUTTON_LOCATOR = By.cssSelector("form[id='login_form']>div>p:last-child>button");
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	public MyAccountPage doLoginWith(String email, String password)
	{
		enterText(EMAIL_ADDRESS_TEXTBOX_LOCATOR, email);
		enterText(PASSWORD_TEXTBOX_LOCATOR, password);
		clickOn(SIGN_IN_BUTTON_LOCATOR);
		
		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		
		return myAccountPage;
	}
	
	
	

}
