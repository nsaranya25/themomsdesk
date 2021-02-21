package com.themomsdesk.utilities;



import org.apache.commons.mail.DefaultAuthenticator;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;


public class SendMail {
 
	public void sendReport(String reportName) throws EmailException
	
	{ 
		
		  // Create the attachment
		  EmailAttachment attachment = new EmailAttachment();
		
		  String reportpath=System.getProperty("user.dir")+"\\test-output\\"+reportName;
		  
		  
		  attachment.setPath(reportpath);
	
		  attachment.setDisposition(EmailAttachment.ATTACHMENT);
		  
		  attachment.setDescription("Email");
		  attachment.setName("Test");

		  // Create the email message
		  MultiPartEmail email = new MultiPartEmail();
		  email.setHostName("smtp.gmail.com");
		  email.setSmtpPort(465);
		 
	    
		  email.setAuthenticator(new DefaultAuthenticator("testseleniumreport@gmail.com", "Testmail!21"));
		 email.setSSL(true);
		  
		  email.setFrom("testseleniumreport@gmail.com");
		
		  email.addTo("nsaranya25@gmail.com", "Saranya");
		  //email.addTo("2011guptashalini@gmail.com","Shalini");
		  
		  email.setSubject("Test Report");
		  email.setMsg("Please find the Test Report attached :");
		

		  // add the attachment
		 email.attach(attachment);
		 

		  // send the email
		  email.send();
		 
		

	}
 
}
