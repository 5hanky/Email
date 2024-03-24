package com.ms.mailsender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.mailsender.service.EmailService;

@RestController
@RequestMapping("/mail")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/send")
	public String sendMail(String to,String cc[], String subject, String body) {
		
		return emailService.sendMail( to ,cc,subject,body);
	}

}
