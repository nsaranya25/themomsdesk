package com.themomsdesk.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import com.themomsdesk.pageObjects.ContactPage;
import com.themomsdesk.pageObjects.HomePage;
import com.themomsdesk.utilities.XLUtils;

public class TC06_ContactFormInvalidData extends BaseClass 
{
	
	@Test(dataProvider="ContactData")
	public void contactFormInvalidData(String name,String email,String message) throws IOException,InterruptedException
	{
		
		HomePage hp6=new HomePage(driver);
		hp6.contactPage();

		ContactPage cp6=new ContactPage(driver);
		
		cp6.getContactName(name);
		
		cp6.getContactEmail(email);
	
		cp6.getContactMessage(message);
		
		
		cp6.clickSubmit();
		
		Thread.sleep(1000);
		
		System.out.println("Response:"+cp6.getTextResponse());
		
		if(cp6.getTextResponse().equals("One or more fields have an error1. Please check and try again.")) 
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver, "TC06_ContactFormInvalidData");
			Assert.assertTrue(false);
		}
		
	
	}
	
	
	@DataProvider(name="ContactData")
	String[][] getData() throws IOException
	{
		
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\themomsdesk\\testData\\ContactData.xlsx";
		
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",0);
		
		
		String contactdata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				contactdata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
				
			}
				
		}
	return  contactdata;
	}

}
