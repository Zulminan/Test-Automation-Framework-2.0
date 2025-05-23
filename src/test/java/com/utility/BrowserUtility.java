package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.*;

public abstract class BrowserUtility {
	
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	
	public WebDriver getDriver()
	{
		return driver.get();
	}

	
	public BrowserUtility(WebDriver driver)
	{
		super();
		
	//	this.driver=driver;
		
		this.driver.set(driver);
	}
	
	public BrowserUtility(String browserName)
	{
		logger.info("Launching browser for "+browserName);
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			
			//driver = new ChromeDriver();
			
			driver.set(new ChromeDriver());
		}
		
		if(browserName.equalsIgnoreCase("edge"))
		{
			
			
			//driver = new EdgeDriver();
			
			driver.set(new EdgeDriver());
		}
		
		if(browserName.equalsIgnoreCase("Firefox"))
		{
			
			//driver = new ChromeDriver();
			
			driver.set(new FirefoxDriver());
		}
		
		else
		{
			logger.error("Invalid Browser Name...Please Select Chrome, Edge or Firefox!");
			System.err.println("Invalid Browser Name...Please Select Chrome, Edge or Firefox!");
		}
	}
	
	
	public BrowserUtility(Browser browserName)
	{
		logger.info("Launching browser for "+browserName);
		
		if(browserName==Browser.CHROME)
		{
			//driver = new ChromeDriver();
			
			driver.set(new ChromeDriver());
		}
		
		else if(browserName==Browser.EDGE)
		{
			//driver = new EdgeDriver();
			
			driver.set(new EdgeDriver());
		}
		
		else if(browserName==Browser.FIREFOX)
		{
			//driver = new EdgeDriver();
			
			driver.set(new FirefoxDriver());
		}
		
		else
		{
			System.err.println("Invalid Browser Name...Please Select Chrome, Edge or Firefox!");
		}
	}
	
	
	public BrowserUtility(Browser browserName, boolean isHeadless)
	{
		logger.info("Launching browser for "+browserName);
		
		if(browserName==Browser.CHROME)
		{
			//driver = new ChromeDriver();
			
			if(isHeadless)
			{
				ChromeOptions chromeOptions = new ChromeOptions();
				
				chromeOptions.addArguments("--headless=new");
				
				chromeOptions.addArguments("--window-size=1920,1080");
				
				driver.set(new ChromeDriver(chromeOptions));
			}
			
			else
			{
				driver.set(new ChromeDriver());
			}
			
			
		}
		
		else if(browserName==Browser.EDGE)
		{
			//driver = new EdgeDriver();
			
			if(isHeadless)
			{
				EdgeOptions edgeOptions = new EdgeOptions();
				
				edgeOptions.addArguments("--headless");
				
				edgeOptions.addArguments("disable-gpu");
				
				driver.set(new EdgeDriver(edgeOptions));
			}
			
			else
			{
				driver.set(new EdgeDriver());
			}
			
			
		}
		
		else if(browserName==Browser.FIREFOX)
		{
			//driver = new EdgeDriver();
			
			if(isHeadless)
			{
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				
				firefoxOptions.addArguments("--headless");
				
				driver.set(new FirefoxDriver(firefoxOptions));
			}
			
			else
			{
				driver.set(new FirefoxDriver());
			}
			
			
		}
		
		else
		{
			System.err.println("Invalid Browser Name...Please Select Chrome, Edge or Firefox!");
		}
	}
	
	
	
	public void goToWebsite(String url)
	{
		logger.info("Visiting the website "+url);
		
		//driver.get(url);
		
		driver.get().get(url);
	}
	
	public void maximizeWindow()
	{
		logger.info("Maximizing the browser window");
		
		//driver.manage().window().maximize();
		
		driver.get().manage().window().maximize();
	}
	
	public void clickOn(By locator)
	{
		logger.info("Finding element with the locator "+locator);
		
        //WebElement webElement = driver.findElement(locator);
		
		WebElement webElement = driver.get().findElement(locator);
        
        logger.info("Element found and now performing click");
		
        webElement.click();
	}
	
	
	public void enterText(By locator, String textToEnter)
	{
		logger.info("Finding element with the locator "+locator);
		
        //WebElement emailAddressTextBoxWebElement = driver.findElement(locator);
		
		WebElement emailAddressTextBoxWebElement = driver.get().findElement(locator);
        
        logger.info("Element found and now enter text "+textToEnter);
		
		emailAddressTextBoxWebElement.sendKeys(textToEnter);
	}
	
	
	public String getVisibleText(By locator)
	{
		logger.info("Finding element with the locator "+locator);
		
		//WebElement element = driver.findElement(locator);
		
		WebElement element = driver.get().findElement(locator);
		
		logger.info("Element found and now returning the visible text "+element.getText());
		
		return element.getText();
	}
	
	public String takeScreenShot(String name)
	{
		
		
		//TakesScreenshot screenshot = (TakesScreenshot)driver;
		
		TakesScreenshot screenshot = (TakesScreenshot)driver.get();
		
		 File screenShotData = screenshot.getScreenshotAs(OutputType.FILE);
		 
		 Date date = new Date();
		 
		 SimpleDateFormat format = new SimpleDateFormat("HH:MM:SS");
		 
		 String timeStamp = format.format(date);
		 
		 String path = System.getProperty("user.dir")+"//screenshots//"+name+" - "+timeStamp+".png";
		 
		 File screenShotFile = new File(path);
		 
		 try 
		 {
			FileUtils.copyFile(screenShotData, screenShotFile);
		} 
		 
		 catch (IOException e) 
		 {
			e.printStackTrace();
		}
		 
		 return path;
	}
	
}
