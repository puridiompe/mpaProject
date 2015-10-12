/**
 * 
 */
package com.puridiompe.mpa.common.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Johnny
 *
 */
@Component
@Aspect
@Order(20)
public class LoggingAspect {

	//@Pointcut("execution(public * com.puridiompe.mpa..*(..))")
	@Pointcut("execution(public * com.puridiompe.mpa..*.impl..*(..))")
	public void anyPublicApplicationMethod() {
	}

	@Before("anyPublicApplicationMethod()")
	public void beforeExecution(JoinPoint joinPoint) {
		StringBuilder logMessage = new StringBuilder();

		logMessage.append("Start method: ");
		logMessage.append(joinPoint.getSignature().getName());
		logMessage.append(" in class ");
		logMessage.append(joinPoint.getTarget().getClass().getName());
		logMessage.append(" ...");
		
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget()
				.getClass());

		if (logger.isDebugEnabled()) {
			logger.debug(logMessage.toString());
			logger.debug("with arguments " + Arrays.toString(joinPoint.getArgs()));
		}
	}

	@AfterReturning(pointcut = "anyPublicApplicationMethod()", returning = "result")
	public void afterReturningExecution(JoinPoint joinPoint, Object result) {

		StringBuilder logMessage = new StringBuilder();

		logMessage.append("Success method: ");
		logMessage.append(joinPoint.getSignature().getName());
		logMessage.append(" in class ");
		logMessage.append(joinPoint.getTarget().getClass().getName());
		
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget()
				.getClass());

		if (logger.isDebugEnabled()) {
			logger.debug(logMessage.toString());
			logger.debug("with result " + result);
		}
	}

	@AfterThrowing(pointcut = "anyPublicApplicationMethod()", throwing = "exception")
	public void afterThrowingExecution(JoinPoint joinPoint, Exception exception) {
		StringBuilder logMessage = new StringBuilder();

		logMessage.append("Failure method: ");
		logMessage.append(joinPoint.getSignature().getName());
		logMessage.append(" in class ");
		logMessage.append(joinPoint.getTarget().getClass().getName());
		
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget()
				.getClass());

		if (logger.isDebugEnabled()) {
			logger.debug(logMessage.toString());
			logger.debug("with exception " + exception.getMessage());
		}

	}

	@After("anyPublicApplicationMethod()")
	public void afterExecution(JoinPoint joinPoint) {
		StringBuilder logMessage = new StringBuilder();

		logMessage.append("... end method: ");
		logMessage.append(joinPoint.getSignature().getName());
		logMessage.append(" in class ");
		logMessage.append(joinPoint.getTarget().getClass().getName());
		
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget()
				.getClass());

		if (logger.isDebugEnabled()) {
			logger.debug(logMessage.toString());
		}
	}
}