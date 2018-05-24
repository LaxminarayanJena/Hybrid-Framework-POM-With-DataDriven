package com.crm.qa.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;



public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT=90;
	public static long IMPLICIT_WAIT=60;
	static Xls_Reader reader;
	
	
	public static ArrayList<Object[]> getDataFromExcel(){

			ArrayList<Object[]> myData = new ArrayList<Object[]>();
			
			try {
				reader = new Xls_Reader("D:\\Projects\\PageObjectModel\\src\\main\\java\\com\\crm\\testdata\\FreeCrmTestData.xlsx");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			    
			     for (int rowNum = 2; rowNum <= reader.getRowCount("contacts"); rowNum++) {
				
			    	 String title = reader.getCellData("contacts", "title", rowNum);
					String firstName = reader.getCellData("contacts", "firstName", rowNum);
					String lastName = reader.getCellData("contacts", "lastname", rowNum);
					String company = reader.getCellData("contacts", "company", rowNum);
					
					

					Object ob[] = { title,firstName,lastName,company};
					myData.add(ob);
					
			}
			return myData;
	}
	
	
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
		}
	
	
	
}
