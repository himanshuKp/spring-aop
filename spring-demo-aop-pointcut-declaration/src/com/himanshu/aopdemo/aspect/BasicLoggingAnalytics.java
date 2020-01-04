package com.himanshu.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class BasicLoggingAnalytics implements UtilityPointcutExpressions {
	
//	run this code before - target object method: "public void addAccount()
	@Before("forDAOwithnogettersandsetter()")	//pointcut expression
	public void basicLoggingAnalytics() {
		System.out.println(">>>>>>>>>> executing basicLoggingAnalytics() through @Pointcut");
	}
	
}
