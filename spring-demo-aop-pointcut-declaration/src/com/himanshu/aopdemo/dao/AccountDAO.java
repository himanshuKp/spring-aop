package com.himanshu.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.himanshu.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String address;
	
	public void addAccount(Account theAccount) {
		System.out.println(getClass()+" calling the getClass() method from the AccountDAO, doing DB operations.\n");
	}
	
	public List<Account> findAccounts(){

//		if(trip) {
//			throw new RuntimeException("No soup for you!!!");
//		}
		
		List<Account> myAccount = new ArrayList<Account>();
		
//		create sample accounts
		Account tempAccont1 = new Account("Ravi", "Gold");
		Account tempAccont2 = new Account("Deepti", "Platinum");
		Account tempAccont3 = new Account("Himanshu", "Silver");
		
//		add them to our accounts list
		myAccount.add(tempAccont1);
		myAccount.add(tempAccont2);
		myAccount.add(tempAccont3);
		
		return myAccount;
	}
	
	public void doWork() {
		System.out.println(getClass()+ " Dont just say, do it!\n");
	}

	public String getName() {
		System.out.println(getClass()+ ": getName()\n");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+ ": setName()\n");
		this.name = name;
	}

	public String getAddress() {
		System.out.println(getClass()+ ": getAddress()\n");
		return address;
	}

	public void setAddress(String address) {
		System.out.println(getClass()+ ": setAddress()\n");
		this.address = address;
	}
	
	
}
