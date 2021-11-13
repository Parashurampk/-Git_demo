package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	public WebDriver ldriver ;
	
	public LoginPage (WebDriver rdriver)
	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	WebElement textun;
	
	@FindBy(name ="password")
	WebElement psw;
	
	@FindBy(name ="btnLogin")
	WebElement submitbutton;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	WebElement LogoutButton;
	
	
	//Created 3 action methods for above 3 elements 
	
	public void setUserName(String uname )
	{
		textun.sendKeys(uname);
	}
	
	public void setPassword(String pwd )
	{
		psw.sendKeys(pwd);
	}
	
	public void Submit( )
	{
		submitbutton.submit();
	}

	public void clickLogout() 
	{
		LogoutButton.submit();
		
	}	
		
}




