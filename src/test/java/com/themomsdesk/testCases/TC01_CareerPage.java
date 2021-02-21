package com.themomsdesk.testCases;


import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;


import com.themomsdesk.pageObjects.HomePage;

public class TC01_CareerPage extends BaseClass 
{
	
	
	@Test
	public void testCareerText() throws InterruptedException, IOException
	{
		
		logger.info("URL is opened");
		
		HomePage hp1=new HomePage(driver);
		//CareerPage cp=new CareerPage(driver);
		Thread.sleep(1000);
		if(hp1. getTextCareer().equals("Career"))
		{
			Assert.assertTrue(true);
			logger.info("The link Career text is correct");
		}
		else
		{
			captureScreen(driver, "TC01_CareerPage");
			Assert.assertTrue(false);
			logger.info("The link Career text is Incorrect");
		}
		
	/*	hp.careerPage();
		Thread.sleep(1000);
		System.out.println(driver.getTitle());
		if(driver.getTitle().equals("Carrer – The Moms Desk"))
		{
			Assert.assertTrue(true);
			logger.info("Career Page link works fine");
		}
		else
		{
			captureScreen(driver, "TC01_CareerPage");
			Assert.assertTrue(false);
			logger.info("Career Page link not works");
		}*/
		
		//cp.getName("Biel");
		//cp.getEmail("biel@gmail.com");
		//File file=new File(System.getProperty("user.dir")+"//Drivers//new.doc");
	//	cp.uploadfile(System.getProperty("user.dir")+"//Drivers//new.doc");
		
		
		
	
		
	
		/*System.out.println("file "+ cp.getfilename());
		
		
		
		System.out.println("Uploaded filename"+ cp.getuploadfileextenstion(file));
		String fileext[]= {".doc",".docx",".pdf"};
		List <String> fileextlist= Arrays.asList(fileext);
		if(fileextlist.contains(cp.getuploadfileextenstion(file)))
		{
			Assert.assertTrue(true);
			//System.out.println(cp.getuploadfilename());
		}
		else
			Assert.assertTrue(false);*/
		
		
		
		
	}

}
