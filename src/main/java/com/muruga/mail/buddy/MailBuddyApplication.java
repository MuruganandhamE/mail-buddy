package com.muruga.mail.buddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class MailBuddyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailBuddyApplication.class, args);
	}

}
