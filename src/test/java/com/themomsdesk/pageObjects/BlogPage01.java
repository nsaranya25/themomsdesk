package com.themomsdesk.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class BlogPage01 
{
	WebDriver blogmdriver; 
	public BlogPage01(WebDriver rdriver)
	{
		blogmdriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(id="author")
	@CacheLookup
	WebElement replyname;
	
	@FindBy(id="email")
	@CacheLookup
	WebElement replyemail;
	
	@FindBy(name="submit")
	@CacheLookup
	WebElement post;
	
	
	
	public void getReplyName(String name)
	{
		
		replyname.clear();
		replyname.sendKeys(name);
	}
	public void getReplyEmail(String mail)
	{
		
		replyemail.clear();
		replyemail.sendKeys(mail);
	}
	
	public void clickpost()
	{
		
		post.click();
	}
}
