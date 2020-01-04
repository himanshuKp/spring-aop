package com.himanshu.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

//	declare pointcut expression
	@Pointcut("execution(*  com.himanshu.aopdemo.dao.*.*(..))")
	private void applyingCommonForDAO() {}
	
//	@Pointcut for getters
	@Pointcut("execution(*  com.himanshu.aopdemo.dao.*.get*(..))")
	private void getters() {}
	
//	@Pointcut for setters
	@Pointcut("execution(*  com.himanshu.aopdemo.dao.*.set*(..))")
	private void setters() {}
	
//	@Pointcut for DAO'S
	@Pointcut("applyingCommonForDAO() && !(getters() || setters())")
	private void forDAOwithnogettersandsetter() {}
	
	
//	run this code before - target object method: "public void addAccount()
	@Before("forDAOwithnogettersandsetter()")	//pointcut expression
	public void beforeAddAccountAdvice() {
		System.out.println(">>>>>>>>>> executing @Before through @Pointcut");
	}
	
	@Before("forDAOwithnogettersandsetter()")	//pointcut expression
	public void anotherImplementation() {
		System.out.println(">>>>>>>>>> executing anotherImplementation() through @Pointcut");
	}
}
