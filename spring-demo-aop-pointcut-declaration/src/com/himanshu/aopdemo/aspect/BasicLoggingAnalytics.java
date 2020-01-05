package com.himanshu.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.himanshu.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class BasicLoggingAnalytics implements UtilityPointcutExpressions {
	
//	run this code before - target object method: "public void addAccount()
	@Before("forDAOwithnogettersandsetter()")	//pointcut expression
	public void basicLoggingAnalytics(JoinPoint theJoinPoint) {
		System.out.println(">>>>>>>>>> executing basicLoggingAnalytics() through @Pointcut");

//		display the method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: " +methodSignature);
		
		if(methodSignature!=null) {
//			get args
			Object[] args = theJoinPoint.getArgs();
			
			for(Object tempArg:args) {
				System.out.println("Object: " +tempArg);
				
//				check if tempArg is an instance of certain class
				if(tempArg instanceof Account) {
					
//					downcast the object
					Account myAccount = (Account) tempArg;
					System.out.println("Name: " +myAccount.getName());
					System.out.println("Level: " +myAccount.getLevel());
					
				}
			}
		}
	}
	

}
