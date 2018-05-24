package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath="//*[contains(text(),'Contacts')]")
	WebElement  contactsLabel ;
	
	@FindBy(id="first_name")
	WebElement  firstName ;
	
	@FindBy(id="surname")
	WebElement  LastName ;
	
	@FindBy(name="client_lookup")
	WebElement  company ;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement save;
	
	//Initialise the pageobjects
		public ContactsPage()
		{
			PageFactory.initElements(driver, this);
			//PageFactory.initElements(driver, LoginPage.class);
		}
		
		
		public boolean verifyContactsLabel()
		{
			return contactsLabel.isDisplayed();
			
		}
		
		public void selectContacts(String name)
		{
			driver.findElement(By.xpath("//a[@context='contact' and contains(text(),'"+ name+ "')]//parent::td[1]//preceding::td[1]//input")).click();
			
		}
		
		public  void createNewContact(String title ,String ftName,String ltName, String comp)
		{
			Select select = new Select(driver.findElement(By.name("title")));
			select.selectByVisibleText(title);
			firstName.sendKeys(ftName);
			LastName.sendKeys(ltName);
			company.sendKeys(comp);
			save.click();
		}
		
		
	
	

}
