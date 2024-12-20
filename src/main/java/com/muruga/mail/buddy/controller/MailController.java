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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/send-mail")
@Slf4j
@Tag(name = "Mail Controller", description = "Mail API endpoints")
public class MailController {

	@Autowired
	private EmailService emailService;

	@PostMapping
	@Operation(summary = "Send an email", description = "Sends an email")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Email sent successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid request payload"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	public void sendMail(@RequestBody MailRequest mailRequest) {
		try {
			emailService.sendEmail(mailRequest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@GetMapping("/info")
	@Operation(summary = "Get Example", description = "Return dummy data")
	public ResponseEntity<?> getSenderMail() {
		Map<String, String> content = new HashMap<String, String>();
		content.put("Email", "saranmuruga437@gmail.com");
		content.put("Name", "Saran Muruganandham");
		content.put("Rolel", "Developer");
		return ResponseEntity.ok(content);
	}

}
