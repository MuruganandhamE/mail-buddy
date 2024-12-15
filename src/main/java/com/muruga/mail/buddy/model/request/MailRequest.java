package com.muruga.mail.buddy.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailRequest {
	
	private String recipient;
	
	private String subject;
	
	private String body;
	
	private String attachment;
	

}
