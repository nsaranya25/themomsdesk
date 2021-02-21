package com.themomsdesk.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.themomsdesk.pageObjects.HomePage;

public class TC02_ContactPage extends BaseClass
{
	@Test
	public void testContactPage() throws IOException,InterruptedException
	{
		HomePage hp2=new HomePage(driver);
		hp2.contactPage();
		Thread.sleep(1000);
		
		
		if(driver.getTitle().equals("Contact – The Moms Desk"))
		{
			
			Assert.assertTrue(true);
			logger.info("Contact Page link works fine");
		}
		else
		{
			
			captureScreen(driver, "TC02_ContactPage");
			Assert.assertTrue(false);
			logger.info("Contact Page link not works");
		}
	}

}
