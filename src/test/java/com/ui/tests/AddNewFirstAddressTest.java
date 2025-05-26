package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

public class AddNewFirstAddressTest extends TestBase
{
	private MyAccountPage myAccountPage;
	

	
	private AddressPOJO address;
	
	@BeforeMethod(description="Valid first time user logs into the application")
	public void setUp()
	{
		myAccountPage = homePage.goToLoginPage().doLoginWith("bakomam786@skrak.com", "password");
		
		address = FakeAddressUtility.getFakeAddress();
	}
	

	@Test
	public void addNewFirstAddress()
	{
		Assert.assertEquals(myAccountPage.gotoAddAddressPage().saveAddress(address), address.getAddressAlias().toUpperCase());
	}
}
