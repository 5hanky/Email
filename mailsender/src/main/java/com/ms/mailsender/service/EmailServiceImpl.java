package com.ms.mailsender.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {
	
	@Value("{$spring.mail.usernam}")
	private String fromEmail;
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public String sendMail(String to, String[] cc, String subject, String body) {
		
		
		try {
			MimeMessage message= javaMailSender.createMimeMessage();
			MimeMessageHelper messageHelper= new MimeMessageHelper(message,true);
			
			messageHelper.setFrom(fromEmail);
			messageHelper.setTo(to);
			messageHelper.setCc(cc);
			messageHelper.setSubject(subject);
			messageHelper.setText(body);
			
			javaMailSender.send(message);
			
			return "Mail sent";
		}catch (Exception e) {
			throw new RuntimeException(e);	
		}
		
	}

}
