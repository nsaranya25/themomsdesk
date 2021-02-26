package com.themomsdesk.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostComment 
{
	WebDriver postdriver; 
	public PostComment(WebDriver rdriver)
	{
		postdriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(linkText ="« Back")
	@CacheLookup
	WebElement back;
	
	public void clickBack()
	{
		back.click();
	}
}
