package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//PageFactory -OR
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUp;
	
	
	@FindBy(xpath="//img[@alt='free crm logo']")
	WebElement crmlogo;
	
	//Initialise the pageobjects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
		//PageFactory.initElements(driver, LoginPage.class);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMImage()
	{
		return crmlogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws InterruptedException
	{
		Thread.sleep(5000);
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return  new HomePage();
	}

}
