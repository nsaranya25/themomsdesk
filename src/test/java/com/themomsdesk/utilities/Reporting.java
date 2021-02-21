package com.themomsdesk.utilities;

//Listener class used to generate Extent reports

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.mail.EmailException;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter
{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	public String repName;
	
		
	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		repName="Test-Report-"+timeStamp+".html";
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\test-output\\"+repName);//specify location of the report
		htmlReporter.loadXMLConfig("./extent-config.xml");
		System.out.println("reporting"+System.getProperty("user.dir")+"\\test-output\\"+repName);
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","");
		extent.setSystemInfo("Environemnt","test");
		extent.setSystemInfo("user","saranya");
		
		htmlReporter.config().setDocumentTitle("TheMomsDesk Test"); // Tile of report
		htmlReporter.config().setReportName("Test Automation Report"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
		
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
		System.out.println("success");
		
		
	}
	
	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
		
		int iend=tr.getMethod().toString().indexOf(".");
		
		String tcname=tr.getMethod().toString().substring(0, iend)+".png";
		
		
		String screenshotPath=System.getProperty("user.dir")+"\\test-output\\Screenshots\\" +tcname;
		//String screenshotPath=".\\test-ouput\\Screenshots\\" +tcname;
		System.out.println("Screenshotpath"+screenshotPath);
		
		File f = new File(screenshotPath); 
		
		if(f.exists())
		{
			
		try {
			logger.fail("Screenshot is below:");
			logger.addScreenCaptureFromPath(screenshotPath);
			
			} 
		catch (IOException e) 
				{
				e.printStackTrace();
				}
		}
		System.out.println("failure");
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
		System.out.println("skipped");
	}
	
	public void onFinish(ITestContext testContext)
	{
	
		extent.flush();
		System.out.println("flushed");
		SendMail sendmail=new SendMail();
		try {
			sendmail.sendReport(repName);
		} catch (EmailException e)
		{
			e.printStackTrace();
		}
		
	}
}