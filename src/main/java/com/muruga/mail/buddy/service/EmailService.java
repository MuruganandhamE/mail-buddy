package com.muruga.mail.buddy.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.muruga.mail.buddy.model.request.MailRequest;

import jakarta.mail.internet.MimeMessage;
import lombok.SneakyThrows;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private TemplateEngine templateEngine;

	@SneakyThrows
	public void sendEmail(MailRequest mailRequest) {

		MimeMessage message = javaMailSender.createMimeMessage();
		
		
		Context context=new Context();
		context.setVariable("message", mailRequest.getBody());
		//process the email content
		String content=templateEngine.process("email-template", context);
		
		
		//attachment
		FileSystemResource fileSystemResource=new FileSystemResource(new File(mailRequest.getAttachment()));
		
		MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
		messageHelper.setTo(mailRequest.getRecipient());
		messageHelper.setSubject(mailRequest.getSubject());
		messageHelper.setText(content,true);
		messageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
		
		javaMailSender.send(message);
	}

}
