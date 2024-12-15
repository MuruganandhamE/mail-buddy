package com.muruga.mail.buddy.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muruga.mail.buddy.model.request.MailRequest;
import com.muruga.mail.buddy.service.EmailService;

@RestController
@RequestMapping("/api/send-mail")
public class MailController {
	
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping
	public void sendMail(@RequestBody MailRequest mailRequest) {
		emailService.sendEmail(mailRequest);
	}
	
	@GetMapping("/info")
	public ResponseEntity<?> getSenderMail() {
		Map<String, String> content=new HashMap<String, String>();
		content.put("Email", "muruganandham.eangovan@gmail.com");
		return ResponseEntity.ok(content);
	}

}
