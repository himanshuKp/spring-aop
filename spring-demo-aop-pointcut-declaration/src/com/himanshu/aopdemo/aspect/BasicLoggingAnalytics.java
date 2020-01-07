package com.himanshu.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
//	run this code before - target object method: "public void addAccount()
	@Before("forDAOwithnogettersandsetter()")	//pointcut expression
	public void basicLoggingAnalytics(JoinPoint theJoinPoint) {
		myLogger.info(">>>>>>>>>> executing basicLoggingAnalytics() through @Pointcut");

//		display the method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info("Method: " +methodSignature);
		
		if(methodSignature!=null) {
//			get args
			Object[] args = theJoinPoint.getArgs();
			
			for(Object tempArg:args) {
				myLogger.info("Object: " +tempArg);
				
//				check if tempArg is an instance of certain class
				if(tempArg instanceof Account) {
					
//					downcast the object
					Account myAccount = (Account) tempArg;
					myLogger.info("Name: " +myAccount.getName());
					myLogger.info("Level: " +myAccount.getLevel());
					
				}
			}
		}
	}
	
	
//	add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(pointcut = "execution(* com.himanshu.aopdemo.dao.AccountDAO.findAccounts())",
			returning = "result")
	public void afterReturningAdviceOnAccounts(JoinPoint joinPoint, List<Account> result) {
		
		String method = joinPoint.getSignature().toShortString();
		
		myLogger.info("\nExecuting: @AfterReturning on method: " +method);
		
		myLogger.info("\nResult is: " +result);
		
		convertToUpperCaseLetters(result);
		
		myLogger.info("\nResult is: " +result);

	}

	private void convertToUpperCaseLetters(List<Account> result) {
		// TODO Auto-generated method stub
//		loop through result
		for(Account tempResult:result) {
			String tempName = tempResult.getName().toUpperCase();
			String tempString = tempResult.getLevel().toUpperCase();
//			myLogger.info(tempName);
			tempResult.setName(tempName);
			tempResult.setLevel(tempString);
		}
	}
	
	@AfterThrowing(pointcut = "execution(* com.himanshu.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theException")
	public void afterThrowingAdvice(JoinPoint joinPoint,Throwable theException) {
		
		String method = joinPoint.getSignature().toShortString();
		
		myLogger.info("\nAfter thrown exception is caught message. Method: " +method);
		
		myLogger.info("Exception: "+theException);
	}
	
	@After("execution(* com.himanshu.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyAdvice(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		
		myLogger.info("\nExecuting @After advice on method: "+method);
	}
	
	@Around("execution(* com.himanshu.aopdemo.service.*.getFortune(..))")
	public Object aroundAdviceService(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("Around Advice Service. Method: " +method);
		
		long startTime = System.currentTimeMillis();
		
		Object response = null;
		
		try {
			response = theProceedingJoinPoint.proceed();
		} catch (Throwable e) {
//			handle and log the exception
			myLogger.warning("Exception occured in the method:" +method+ ", Exception: " +e.getMessage());
			
//			throw normal response to the main calling program
//			handling the exception, main program will never know that exception occured
			response = "There is a delay in the service. Another service is on its way now!";
			
//			rethrow exception
//			throw e;
		}
		
		long endTime = System.currentTimeMillis();
		
		long timeTaken = endTime - startTime;
		
		myLogger.info("====> Duration: " +timeTaken/1000+ " seconds.");
		
		return response;
	}
	
}
