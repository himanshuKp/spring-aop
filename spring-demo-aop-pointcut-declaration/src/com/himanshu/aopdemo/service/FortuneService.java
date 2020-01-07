package com.himanshu.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class FortuneService {
	
	public String getFortune() {
		
//		simulate a delay
		try {
			TimeUnit.SECONDS.sleep(5);
		}
		catch(Exception exp) {
			exp.printStackTrace();
		}
		
		return "There is a delay in a service";
	}

	public String getFortune(boolean tripWire) {
		throw new RuntimeException();
	}
	
}
