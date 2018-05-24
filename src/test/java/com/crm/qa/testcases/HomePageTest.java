package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;



public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testutil;
	ContactsPage contactspage;
	public HomePageTest()
	{
		super();
		//we have to create consttructor so that i can call super class constructor
	}
	
	
	@BeforeMethod
	
	public void setUp() throws InterruptedException
	{
		initialization();
		contactspage= new ContactsPage();
		testutil= new TestUtil();
		loginPage= new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
				
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO" ,"HomePage title not matched");
	}
	
	@Test(priority=2)
	public void verifyUsername()
	{
		testutil.switchToFrame();
		Assert.assertTrue(homePage.verifyuserName());
	}
	
	
	@Test(priority=3)
	public void verifyContactsLinkText()
	{
		testutil.switchToFrame();
		contactspage=homePage.clickOnContacsLink();
	}



@AfterMethod

public void tearDown()
{
	driver.quit();
}
}