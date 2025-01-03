package com.muruga.mail.buddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableAdminServer
public class MailBuddyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailBuddyApplication.class, args);
	}

}
