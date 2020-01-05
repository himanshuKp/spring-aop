package com.himanshu.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	
//	add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(pointcut = "execution(* com.himanshu.aopdemo.dao.AccountDAO.findAccounts())",
			returning = "result")
	public void afterReturningAdviceOnAccounts(JoinPoint joinPoint, List<Account> result) {
		
		String method = joinPoint.getSignature().toShortString();
		
		System.out.println("\nExecuting: @AfterReturning on method: " +method);
		
		System.out.println("\nResult is: " +result);
		
		convertToUpperCaseLetters(result);
		
		System.out.println("\nResult is: " +result);

	}


	private void convertToUpperCaseLetters(List<Account> result) {
		// TODO Auto-generated method stub
//		loop through result
		for(Account tempResult:result) {
			String tempName = tempResult.getName().toUpperCase();
			System.out.println(tempName);
			tempResult.setName(tempName);
		}
	}
	
	@AfterThrowing(pointcut = "execution(* com.himanshu.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theException")
	public void afterThrowingAdvice(JoinPoint joinPoint,Throwable theException) {
		
		String method = joinPoint.getSignature().toShortString();
		
		System.out.println("\nAfter thrown exception is caught message. Method: " +method);
		
		System.out.println("Exception: "+theException);
	}

}
