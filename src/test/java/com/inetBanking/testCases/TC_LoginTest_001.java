package com.inetBanking.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
		
			@Test
			public void LoginTest() throws InterruptedException, IOException
			{
				driver.get(baseURL);
				logger.info("URL is openeded");
				
				driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		        
		        driver.manage().deleteAllCookies();
		        driver.manage().window().maximize();
				
				LoginPage lp = new LoginPage(driver); //created object for LoginPage to call the UN pwd methods 
				lp.setUserName(username);
				logger.info("Entered user name ");
				
				lp.setPassword(password);
				logger.info("Entered password");
				
				lp.Submit();
				logger.info("login sucessfully");
				Thread.sleep(4000);
				
				String Title = driver.getTitle();
				System.out.println(Title);
				
				if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
				{
					Assert.assertTrue(true);
					logger.info("Login test passed");
				}
				else
				{
					captureScreen(driver,"loginTest");
					Assert.assertFalse(false);
					logger.info("Login test failed");
				}
	}
}

