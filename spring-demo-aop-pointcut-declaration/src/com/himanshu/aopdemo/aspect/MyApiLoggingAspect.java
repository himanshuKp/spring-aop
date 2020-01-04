package com.himanshu.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiLoggingAspect implements UtilityPointcutExpressions {

	@Before("forDAOwithnogettersandsetter()")	//pointcut expression
	public void apiLoggingANalytics() {
		System.out.println(">>>>>>>>>> executing apiLoggingANalytics() through @Pointcut");
	}
	
}
