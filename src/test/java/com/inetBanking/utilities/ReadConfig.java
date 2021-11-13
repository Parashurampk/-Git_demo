package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

static Properties pro;
	
	public ReadConfig()
	{
		//To read configuration properties file to created one constructor 
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);													
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
		public String GetApplicationURL()
		{
			String Url=pro.getProperty("baseURL");
			return Url;
		}
		
		public  String getUserName()
		{
		String username=pro.getProperty("username");
		return username;
		}
		
		public  String getPassword()
		{
		String password=pro.getProperty("password");
		return password;
		}
		
		public String getChromePath()
		{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
		}

		public String getFirefox()
		{
			String firefox=pro.getProperty("firefox");
			return firefox;
		}
		

}
