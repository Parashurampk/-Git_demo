package com.inetBanking.testCases;


import java.io.File;


/**
* The TestBase class is the base class to fetch environment specific configuration parameters from 
* Jenkins/Maven. Based on the parameters, it performs the browser setup and tear-down functions.
* 
* @author  Parashuram
*/

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;


public class BaseClass 
{
	ReadConfig readcong= new ReadConfig();
	public String baseURL=readcong.GetApplicationURL();
	public String username =readcong.getUserName();
	public String password=readcong.getPassword();
	public static WebDriver driver ;
	public static Logger logger;

	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br)
	{
		
		//To show the logs of the activities 
		logger= Logger.getLogger("inetBanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if (br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readcong.getChromePath());
			
			driver= new ChromeDriver();
			
		}
		else if (br.equals("firefox"))
		{
			System.setProperty("webdriver.Firefox.driver",readcong.getFirefox());
			
			driver= new ChromeDriver();
		}
			
		}
	  
	   
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

public void captureScreen(WebDriver driver, String tname) throws IOException {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot taken");
}

public String randomestring()
{
	String generatedstring=RandomStringUtils.randomAlphabetic(8);
	return(generatedstring);
}

public static String randomeNum() {
	String generatedString2 = RandomStringUtils.randomNumeric(4);
	return (generatedString2);
}


}

