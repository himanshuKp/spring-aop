package com.himanshu.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

//	this is where we add all of our related advices for logging
	
	
//	lets start with and @Before advice
	
//	run this code before - target object method: "public void addAccount()
	@Before("execution(* add*(com.himanshu.aopdemo.Account,..))")	//pointcut expression
	public void beforeAddAccountAdvice() {
		System.out.println(">>>>>>>>>> executing @Before advice on addAccount()");
	}
	
}
