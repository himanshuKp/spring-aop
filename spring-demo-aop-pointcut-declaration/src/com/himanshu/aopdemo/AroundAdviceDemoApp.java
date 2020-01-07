package com.himanshu.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.himanshu.aopdemo.service.FortuneService;

public class AroundAdviceDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundAdviceDemoApp.class.getName());
	
	public static void main(String[] args) {
				
//		read spring config java class
		AnnotationConfigApplicationContext theContext = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
//		get the account bean from spring container
		FortuneService theFortuneService = theContext.getBean("fortuneService",FortuneService.class);
	
		myLogger.info("Main program: AoundAdviceDemoApp");
		
		myLogger.info("Calling theFortuneService method.");
		
		boolean tripWire = true;
		String message = theFortuneService.getFortune(tripWire);
		
		myLogger.info("\nMethod message: " +message);

		myLogger.info("Finished");
		
//		close the context
		theContext.close();	
	}

}
