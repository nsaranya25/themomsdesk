package com.themomsdesk.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver ldriver; 
	public HomePage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(linkText="Home")
	@CacheLookup
	WebElement home;
	
	@FindBy(linkText="About")
	@CacheLookup
	WebElement about;
	
	@FindBy(linkText="Services")
	@CacheLookup
	WebElement services;
	
	@FindBy(linkText="Blog")
	@CacheLookup
	WebElement blog;
	
	@FindBy(linkText="Carrer")     
	@CacheLookup
	WebElement career;
	
	@FindBy(linkText="Contact")
	@CacheLookup
	WebElement contact;
	
	
	
	@FindBy(id="cz_84529")
	@CacheLookup
	WebElement automationtesting;
	
	@FindBy(id="cz_22927")
	@CacheLookup
	WebElement manualtesting;
	
	
	@FindBy(id="cz_86823")
	@CacheLookup
	WebElement acceptancetesting;
	
	@FindBy(xpath="//body[1]/div[2]/div[1]/header[1]/div[1]/div[1]/div[1]/div[3]/div[1]/a[1]/span[1]")
	@CacheLookup
	WebElement quickcontact;
	
	
	@FindBy(id="cz_11362")
	@CacheLookup
	WebElement customersatisfaction;
	
	
	
	@FindBy(id="cz_96253")
	@CacheLookup
	WebElement womenempowerment;
	
	
	@FindBy(id="cz_41018")
	@CacheLookup
	WebElement ownership;
	
	
	@FindBy(id="cz_101406")
	@CacheLookup
	WebElement payhour;
	
	@FindBy(className="cz_wpe_content")
	@CacheLookup
	WebElement customerconnect;
	
	
	public void gohomePage()
	{
		
		home.click();
	}
	public void aboutPage()
	{
		about.click();
	}
	public void servicesPage()
	{
		services.click();
	}
	public void blogPage()
	{
		blog.click();
	}
	public void careerPage()
	{
		career.click();
	}
	public String getTextCareer()
	{
		return career.getText();
	}
	public void contactPage()
	{
		contact.click();
	}
	
	public void clickAutomation() throws InterruptedException
	{
		automationtesting.click();
	}
	public void clickManual()
	{
	
		manualtesting.click();
	}
	public void clickAcceptance()
	{
	
		
		acceptancetesting.click();
	}
	public void clickQuickContact()
	{
	
		quickcontact.click();
	}
	
	
}

