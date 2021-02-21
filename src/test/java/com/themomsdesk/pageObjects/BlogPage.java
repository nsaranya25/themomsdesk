package com.themomsdesk.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlogPage 
{
	WebDriver blogdriver; 
	public BlogPage(WebDriver rdriver)
	{
		blogdriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(className="cz_readmore")
	@CacheLookup
	WebElement readmore;
	
	
	public void clickReadMore()
	{
		
		readmore.click();
	}
	
}
