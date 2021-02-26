package com.themomsdesk.testCases;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.themomsdesk.utilities.ReadConfig;



public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	
	public String baseURL=readconfig.getApplicationURL();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeTest
	public void setup(String br) 
	{
		
		logger=Logger.getLogger("TheMomsDesk");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver=new FirefoxDriver();
		}
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		
		
		
		
	}
	
	@AfterTest
	public void tearDown() throws EmailException
	{
		
		driver.quit();
		
		
	}
	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String time = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		System.out.println(System.getProperty("user.dir")+"\\test-output\\Screenshots\\"+tname+time+".png");
		
		File target = new File(System.getProperty("user.dir")+"\\test-output\\Screenshots\\"+tname+time+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");

	}

}
