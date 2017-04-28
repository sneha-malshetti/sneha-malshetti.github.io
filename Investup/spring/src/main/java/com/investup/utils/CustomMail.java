package com.investup.utils;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class CustomMail {
	
		@Autowired
		ServletContext servletContext;
		
//		@Autowired
//	    private CustomMail customMail;
//		
//	    @Autowired
//		JavaMailSender mailSender;
//		
		
		/*public CustomMailer(JavaMailSender mailSender) {
			this.mailSender = mailSender;
		}
		*/
		public void sendMail(JavaMailSender mailSender, String recipient, String subject, String message) {
			recipient = "recepientemail@email.com";    
	        SimpleMailMessage email = new SimpleMailMessage();
	        email.setFrom("senderEmailId@gmail.com");
	        email.setTo(recipient);
	        email.setSubject(subject);
	        email.setText(message);
	        
	        mailSender.send(email);
		 }

	
}
