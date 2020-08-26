package com.example.aspect;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class CentralLoggingHandler {

	private Logger logger = LogManager.getLogger();

	@Autowired
	private HttpServletRequest request;

	@Before("execution(* com.example.controller.*.*(..))")
	public void before(JoinPoint joinPoint) {

		logger.info("\n\nRequest Type {} , Path {} from {}", request.getMethod(), request.getRequestURI(),
				request.getHeader("User-Agent"));
		logger.info(" Allowed execution for {}", joinPoint);
	}

	@AfterReturning(value = "execution(* com.example.controller.*.*(..))", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("returned with value {}", result);
	}

	@After(value = "execution(* com.example.controller.*.*(..))")
	public void after(JoinPoint joinPoint) {
		logger.info("after method {}", joinPoint);
	}

	@AfterThrowing(pointcut = "execution(* com.example.controller.*.*(..))", throwing = "e")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
		logger.error("An exception has been thrown in {}", joinPoint.getSignature().getName());
		logger.error(e);
	}

}
