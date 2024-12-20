package com.muruga.mail.buddy.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@Pointcut("execution(* com.muruga.mail.buddy.controller..*(..))")
	public void controllerMethods() {
	}

	@Before("controllerMethods()")
	public void logRequest(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		logger.info("Request Payload: {}", Arrays.toString(args));
	}

	@AfterReturning(pointcut = "controllerMethods()", returning = "result")
	public void logResponse(JoinPoint joinPoint, Object result) {
		logger.info("Response Payload: {}", result);
	}

	@AfterThrowing(pointcut = "controllerMethods()", throwing = "error")
	public void logException(JoinPoint joinPoint, Throwable error) {
		logger.error("Exception: {}", error.getMessage());
	}

}
