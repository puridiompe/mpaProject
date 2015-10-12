/**
 * 
 */
package com.puridiompe.mpa.common.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.util.StopWatch.TaskInfo;

/**
 * @author Johnny
 *
 */
@Component
@Aspect
@Order(10)
public class ProfilerAspect {

	private static final Logger logger = LoggerFactory
			.getLogger(ProfilerAspect.class);

	@Pointcut("execution(public * com.puridiompe.mpa..*(..))")
	public void anyPublicBusinessMethod() {
	}

	@Pointcut("@annotation(com.puridiompe.mpa.common.annotation.ProfileMethod)")
	public void anyBusinessProfileMethod() {
	}

	@Around("anyPublicBusinessMethod() && anyBusinessProfileMethod()")
	public Object profileExecution(ProceedingJoinPoint joinPoint)
			throws Throwable {

		StopWatch stopWatch = new StopWatch(joinPoint.getSignature().getName());
		stopWatch.start(joinPoint.toShortString());
		boolean isExceptionThrown = false;
		try {
			// execute the profiled method
			return joinPoint.proceed();
		} catch (RuntimeException e) {
			isExceptionThrown = true;
			throw e;
		} finally {
			stopWatch.stop();

			TaskInfo taskInfo = stopWatch.getLastTaskInfo();

			StringBuilder logMessage = new StringBuilder();
			logMessage.append(joinPoint.getTarget().getClass().getName());
			logMessage.append(".");
			logMessage.append(joinPoint.getSignature().getName());

			logMessage.append(" with arguments "
					+ Arrays.toString(joinPoint.getArgs()));

			// Log the method's profiling result
			String profileMessage = taskInfo.getTaskName() + ": "
					+ taskInfo.getTimeMillis() + " ms"
					+ (isExceptionThrown ? " (thrown Exception)" : "");

			if (logger.isDebugEnabled()) {
				logger.debug(logMessage.toString());
				// Logger.debug(this,
				// "execution time: " + stopWatch.getTotalTimeMillis() + " ms");
				logger.debug(profileMessage);
				// Logger.debug(this, stopWatch.prettyPrint());
			}
		}
	}

}
