package com.mindgate.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	@Autowired
	private JavaMailSender javaMailSender;
	
	public int sendEmail(String toEmail ,String subject ,String body) {
		try {
			System.err.println("toEmail"+toEmail);
			SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
			simpleMailMessage.setFrom("jadhavnikita315@gmail.com");
			simpleMailMessage.setTo(toEmail);
			simpleMailMessage.setText(body);
			simpleMailMessage.setSubject(subject);
			
			javaMailSender.send(simpleMailMessage);
		  return 1;
		} catch (Exception e) {
			return -1;
		}
		
	}

}
