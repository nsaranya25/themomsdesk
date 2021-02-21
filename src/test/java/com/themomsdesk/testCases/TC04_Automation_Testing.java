package com.themomsdesk.testCases;

import java.io.IOException;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.themomsdesk.pageObjects.HomePage;

public class TC04_Automation_Testing extends BaseClass 
{
	@Test
	public void testAtutomationTesting() throws InterruptedException, IOException
	{
		System.out.println("url");
		HomePage hp4=new HomePage(driver);
		System.out.println("click");
		hp4.clickAutomation();
		String winHandle;
		String firstWinHandle;
		String secondWinHandle;
		Thread.sleep(5000);
		Set<String> handles = driver.getWindowHandles();
		firstWinHandle = driver.getWindowHandle();
		handles.remove(firstWinHandle);
		winHandle= handles.iterator().next();
		if(winHandle!= firstWinHandle)
		{
			secondWinHandle = winHandle;
			driver.switchTo().window(secondWinHandle);
		}
		System.out.println("get title of driver:"+driver.getTitle());
		if(driver.getTitle().equals("Services – Business 4"))
		{
			Assert.assertTrue(true);
			logger.info("The Automation link navigates correctly");
		}
		else
		{
			captureScreen(driver, "TC04_Automation_Testing");
			Assert.assertTrue(false);
			logger.info("The Automation link not navigates correctly");
		}
		
		
	}
}
