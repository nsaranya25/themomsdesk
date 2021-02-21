package com.themomsdesk.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage 
{
	WebDriver condriver; 
	public ContactPage(WebDriver rdriver)
	{
		condriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(name="your-name")
	@CacheLookup
	WebElement name;
	
	@FindBy(name="your-email")
	@CacheLookup
	WebElement email;
	
	@FindBy(name="your-message")
	@CacheLookup
	WebElement message;
	
	
	@FindBy(name="submit")
	@CacheLookup
	WebElement submit;
	
	@FindBy(className="wpcf7-response-output")
	@CacheLookup
	WebElement response;
	
	public void getContactName(String contactname)
	{
		name.clear();
		name.sendKeys(contactname);
	}
	public void getContactEmail(String contactemail)
	{
		email.clear();
		email.sendKeys(contactemail);
	}
	public void getContactMessage(String contactmsg)
	{
		message.clear();
		message.sendKeys(contactmsg);
	}
	public void clickSubmit()
	{
		submit.click();
	}
	public String getTextResponse()
	{
		return response.getText();
	}
	
	
}


