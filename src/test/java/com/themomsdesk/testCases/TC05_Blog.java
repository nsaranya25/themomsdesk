package com.themomsdesk.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.themomsdesk.pageObjects.BlogPage;
import com.themomsdesk.pageObjects.BlogPage01;
import com.themomsdesk.pageObjects.HomePage;
import com.themomsdesk.pageObjects.PostComment;

public class TC05_Blog extends BaseClass 
{
	@Test
	public void testBlog() throws InterruptedException, IOException
	{
		
		HomePage hp5=new HomePage(driver);
		hp5.blogPage();
		
		Thread.sleep(1000);
		
		if(driver.getTitle().equals("Blog – The Moms Desk"))
		{
			Assert.assertTrue(true);
			logger.info("The Blog page navigates correctly");
		}
		else
		{
			captureScreen(driver, "TC05_Blog");
			Assert.assertTrue(false);
			logger.info("The Blog page not navigates correctly");
		}
		
		BlogPage bg=new BlogPage(driver);
		
		bg.clickReadMore();
		
		if(driver.getTitle().equals("Hello world! – The Moms Desk"))
		{
			Assert.assertTrue(true);
			logger.info("The Readmore navigates correctly");
		}
		else
		{
			captureScreen(driver, "TC05_Blog_readmore");
			Assert.assertTrue(false);
			logger.info("The Readmore not navigates correctly");
		}
		
		BlogPage01 bgreply=new BlogPage01(driver);
		
		
		bgreply.getReplyName("23");
		bgreply.getReplyEmail("sdfadfs.com");
		bgreply.clickpost();
		
		

		if(driver.getTitle().equals("Comment Submission Failure"))
		{
			Assert.assertTrue(true);
			logger.info("The Failure Comment navigates correctly");
		}
		else
		{
			captureScreen(driver, "TC05_Blog_readmore");
			Assert.assertTrue(false);
			logger.info("The Failure Comment not navigates correctly");
		}
		
		PostComment pc=new PostComment(driver);
		pc.clickBack();
		
		
		
	}
	
}
