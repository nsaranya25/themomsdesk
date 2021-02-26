package com.themomsdesk.testCases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.themomsdesk.pageObjects.HomePage;

public class TC04_Automation_Testing extends BaseClass 
{
	@Test
	public void testAtutomationTesting() throws InterruptedException, IOException
	{
		
		HomePage hp4=new HomePage(driver);
		hp4.gohomePage();
		
		hp4.clickAutomation();
		String winHandle;
		String parent=driver.getWindowHandle();
		
		Thread.sleep(5000);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> I1=handles.iterator();
		String child_title=null;
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
				child_title=driver.switchTo().window(child_window).getTitle();
				driver.close();
				
			}
		}
		driver.switchTo().window(parent);
		
		
		/*firstWinHandle = driver.getWindowHandle();
		//handles.remove(firstWinHandle);
		winHandle= handles.iterator().next();
		if(winHandle!= firstWinHandle)
		{
			secondWinHandle = winHandle;
			driver.switchTo().window(secondWinHandle);
		}
		System.out.println("get title of driver:"+driver.getTitle());*/
		if(child_title.equals("Services – Business 4"))
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
		
		//driver.close();
		//driver.switchTo().window(firstWinHandle);
		
	}
}
