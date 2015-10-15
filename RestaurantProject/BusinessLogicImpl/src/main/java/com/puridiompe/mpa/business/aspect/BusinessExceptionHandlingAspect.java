/**
 * 
 */
package com.puridiompe.mpa.business.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.puridiompe.mpa.business.exception.BusinessException;
import com.puridiompe.mpa.business.exception.GenericBusinessException;

/**
 * @author Johnny
 *
 */
@Component
@Aspect
@Order(30)
public class BusinessExceptionHandlingAspect {

	@Pointcut("execution(public * com.puridiompe.mpa.business.impl..*(..))")
	public void anyPublicBusinessMethod() {
	}

	@Around("anyPublicBusinessMethod()")
	public Object exceptionHandlingExecution(ProceedingJoinPoint joinPoint)
			throws Throwable {

		try {
			return joinPoint.proceed();
		} catch (Exception exception) {

			Logger logger = LoggerFactory.getLogger(joinPoint.getTarget()
					.getClass());

			logger.error("Exception", exception);

			if (!(exception instanceof BusinessException
					|| exception instanceof AuthenticationException || exception instanceof AccessDeniedException)) {
				throw new GenericBusinessException("001",
						"Error no controlado en Business layer", exception);
			} else {
				throw exception;
			}
		} finally {

		}
	}
}
