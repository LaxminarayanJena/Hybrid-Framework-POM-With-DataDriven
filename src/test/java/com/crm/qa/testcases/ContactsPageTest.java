package com.crm.qa.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testutil;
	ContactsPage contactspage;
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		contactspage= new ContactsPage();
		testutil= new TestUtil();
		loginPage= new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();
		contactspage=homePage.clickOnContacsLink();
				
	}

	
	@Test(priority=1)
	public void verifyContactsPageLabel() 
	{
		Assert.assertTrue(contactspage.verifyContactsLabel(),"contacts label is missing");
		
	}
	
	@Test(priority=2)
	public void selectcontactsByname() 
	{
		contactspage.selectContacts("Michael Jackson");
		contactspage.selectContacts("Tom Peter");
	}
	
	
	
	@DataProvider
	public Iterator<Object[]> getTestData(){
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
	}
	
	
	@Test(dataProvider="getTestData",priority=3)
	public void validateCreateNewContact(String title, String firstName,String lastName,String company) 
	{
		homePage.clickOnNewContactLink();
		contactspage.createNewContact(title, firstName, lastName, company);
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
