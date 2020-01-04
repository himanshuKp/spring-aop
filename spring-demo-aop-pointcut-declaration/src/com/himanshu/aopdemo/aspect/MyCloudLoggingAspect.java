package com.himanshu.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyCloudLoggingAspect implements UtilityPointcutExpressions {

	@Before("forDAOwithnogettersandsetter()")	//pointcut expression
	public void cloudLoggingAnalytics() {
		System.out.println(">>>>>>>>>> executing cloudLoggingAnalytics() through @Pointcut");
	}
	
}
