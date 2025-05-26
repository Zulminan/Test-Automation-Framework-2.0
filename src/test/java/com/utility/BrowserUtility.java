package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.*;

public abstract class BrowserUtility {
	
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	private Logger logger = LoggerUtility.getLogger(this.getClass());
	
	private WebDriverWait wait;
	
	
	public WebDriver getDriver()
	{
		return driver.get();
	}

	
	public BrowserUtility(WebDriver driver)
	{
		super();
		
		this.driver.set(driver);
		
		wait = new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
	}
	
	public BrowserUtility(String browserName)
	{
		logger.info("Launching browser for "+browserName);
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			
			//driver = new ChromeDriver();
			
			driver.set(new ChromeDriver());
			
			wait = new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
		}
		
		if(browserName.equalsIgnoreCase("edge"))
		{
			
			
			//driver = new EdgeDriver();
			
			driver.set(new EdgeDriver());
			
			wait = new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
		}
		
		if(browserName.equalsIgnoreCase("Firefox"))
		{
			
			//driver = new ChromeDriver();
			
			driver.set(new FirefoxDriver());
			
			wait = new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
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
			
			wait = new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
		}
		
		else if(browserName==Browser.EDGE)
		{
			//driver = new EdgeDriver();
			
			driver.set(new EdgeDriver());
			
			wait = new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
		}
		
		else if(browserName==Browser.FIREFOX)
		{
			//driver = new EdgeDriver();
			
			driver.set(new FirefoxDriver());
			
			wait = new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
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
				
				wait = new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
			}
			
			else
			{
				driver.set(new ChromeDriver());
				
				wait = new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
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
				
				wait = new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
			}
			
			else
			{
				driver.set(new EdgeDriver());
				
				wait = new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
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
				
				wait = new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
			}
			
			else
			{
				driver.set(new FirefoxDriver());
				
				wait = new WebDriverWait(getDriver(),Duration.ofSeconds(30L));
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
		
		//WebElement webElement = driver.get().findElement(locator);
		
		WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        
        logger.info("Element found and now performing click");
		
        webElement.click();
	}
	
	public void clickOnCheckBox(By locator)
	{
		logger.info("Finding element with the locator "+locator);
		
        //WebElement webElement = driver.findElement(locator);
		
		//WebElement webElement = driver.get().findElement(locator);
		
		WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        
        logger.info("Element found and now performing click");
		
        webElement.click();
	}
	
	public void clickOn(WebElement element)
	{
		
        logger.info("Element found and now performing click");
		
        element.click();
	}
	
	
	public void enterText(By locator, String textToEnter)
	{
		logger.info("Finding element with the locator "+locator);
		
        //WebElement emailAddressTextBoxWebElement = driver.findElement(locator);
		
		//WebElement element = driver.get().findElement(locator);
		
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        
        logger.info("Element found and now enter text "+textToEnter);
		
        element.sendKeys(textToEnter);
	}
	
	
	public void clearText(By textBoxLocator)
	{
		logger.info("Finding element with the locator "+textBoxLocator);
		
		//WebElement element = driver.get().findElement(textBoxLocator);
		
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxLocator));
        
        logger.info("Element found and clearing the text "+textBoxLocator);
		
        element.clear();
	}
	
	
	public void selectFromDropDown(By dropDownLocator, String optionToSelect)
	{
		logger.info("Finding element with the locator "+dropDownLocator);
		
		WebElement element = driver.get().findElement(dropDownLocator);
		
		Select select = new Select(element);
		
		logger.info("Selecting the option "+optionToSelect);
		
		select.selectByVisibleText(optionToSelect);
		
		
	}
	
	
	public void enterSpecialKey(By locator, Keys keyToEnter)
	{
		logger.info("Finding element with the locator "+locator);
		
        //WebElement emailAddressTextBoxWebElement = driver.findElement(locator);
		
		//WebElement emailAddressTextBoxWebElement = driver.get().findElement(locator);
		
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        
        logger.info("Element found and now enter special key "+keyToEnter);
		
        element.sendKeys(keyToEnter);
	}
	
	
	public String getVisibleText(By locator)
	{
		logger.info("Finding element with the locator "+locator);
		
		//WebElement element = driver.findElement(locator);
		
		WebElement element = driver.get().findElement(locator);
		
		logger.info("Element found and now returning the visible text "+element.getText());
		
		return element.getText();
	}
	
	public String getVisibleText(WebElement element)
	{
		
		logger.info("Returning the visible text "+element.getText());
		
		return element.getText();
	}
	
	
	
	public List<String> getAllVisibleText(By locator)
	{
		logger.info("Finding all elements with the locator "+locator);
		
		//WebElement element = driver.findElement(locator);
		
		List<WebElement> elementList = driver.get().findElements(locator);
		
		logger.info("Elements found and now printing the list of elements");
		
		List<String> visibleTextList = new ArrayList<String>();
		
		for(WebElement element : elementList)
		{
			visibleTextList.add(getVisibleText(element));
		}
		
		return visibleTextList;
	}
	
	public List<WebElement> getAllElements(By locator)
	{
		logger.info("Finding all elements with the locator "+locator);
		
		//WebElement element = driver.findElement(locator);
		
		List<WebElement> elementList = driver.get().findElements(locator);
		
		logger.info("Elements found and now printing the list of elements");
		
		
		return elementList;
	}
	
	
	
	public String takeScreenShot(String name)
	{
		
		
		//TakesScreenshot screenshot = (TakesScreenshot)driver;
		
		TakesScreenshot screenshot = (TakesScreenshot)driver.get();
		
		 File screenShotData = screenshot.getScreenshotAs(OutputType.FILE);
		 
		 Date date = new Date();
		 
		 SimpleDateFormat format = new SimpleDateFormat("HH:MM:SS");
		 
		 String timeStamp = format.format(date);
		 
		// String path = System.getProperty("user.dir")+"//screenshots//"+name+" - "+timeStamp+".png";
		 
		 String path = "./screenshots/"+name+" - "+timeStamp+".png";
		 
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
