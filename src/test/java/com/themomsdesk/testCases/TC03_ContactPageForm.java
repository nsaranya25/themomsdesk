package com.themomsdesk.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.themomsdesk.pageObjects.ContactPage;
import com.themomsdesk.pageObjects.HomePage;

public class TC03_ContactPageForm extends BaseClass
{
	@Test
	public void testContactPageForm() throws IOException,InterruptedException
	{
		HomePage hp3=new HomePage(driver);
		hp3.contactPage();
		Thread.sleep(1000);
		
		ContactPage cp=new ContactPage(driver);
		cp.getContactName("2342");
		cp.clickSubmit();
		Thread.sleep(1000);
		System.out.println("Response Message:"+cp.getTextResponse());
		
		if(cp.getTextResponse().equals("One or more fields have an error. Please check and try again."))
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver, "TC03_ContactPageForm");
			Assert.assertTrue(false);
		}
		
		cp.getContactName("Biel");
		cp.getContactEmail("asdfsf.com");
		cp.getContactMessage("Hi Good Morning!");
		cp.clickSubmit();
		Thread.sleep(1000);
		
		if(cp.getTextResponse().equals("One or more fields have an error. Please check and try again1.")) //Purposefully given wrong text to make the test fail
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver, "TC03_ContactPageForm");
			Assert.assertTrue(false);
		}
		
		
	}
		
}
