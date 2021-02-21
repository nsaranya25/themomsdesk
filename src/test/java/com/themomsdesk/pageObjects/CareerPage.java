package com.themomsdesk.pageObjects;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CareerPage 
{
	WebDriver cardriver; 
	public CareerPage(WebDriver rdriver)
	{
		cardriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(name="your-name")
	@CacheLookup
	WebElement name;
	
	@FindBy(name="your-email")
	@CacheLookup
	WebElement email;
	
	
	@FindBy(name="file-596")
	@CacheLookup
	WebElement upload;
	
	//@FindBy([placeholder="No file chosen"])
	
	
	@FindBy(name="your-message")
	@CacheLookup
	WebElement message;
	
	@FindBy(name="submit")
	@CacheLookup
	WebElement submit;
	
	public void getName(String applicantsname)
	{
		name.sendKeys(applicantsname);
	}
	

	public void getEmail(String applicantsemail)
	{
		email.sendKeys(applicantsemail);
	}
	

	public void uploadfile(String file)
	{
		upload.sendKeys(file);
	}
	
/*	public String getfilename()
	{
	   return upload.get;
	}
	*/
	public String getuploadfileextenstion(File file)
	{
		String name=file.getName();
		try {
			return name.substring(name.lastIndexOf("."));
		}
		catch(Exception e) {
			return "";
		}
	}
	
	
	
	
	public void getMessage(String applicantsmessage)
	{
		message.sendKeys(applicantsmessage);
	}
	
	public void clickSubmit()
	{
		submit.click();
	}
	
	
	
	
}
