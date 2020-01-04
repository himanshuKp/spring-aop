package com.himanshu.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.himanshu.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount) {
		
		System.out.println(getClass()+" calling the getClass() method from the AccountDAO, doing DB operations.");
	
	}
	
	public void doWork() {
		System.out.println("Dont just say, do it!");
	}
	
}
