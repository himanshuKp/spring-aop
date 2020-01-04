package com.himanshu.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.himanshu.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String address;
	
	public void addAccount(Account theAccount) {
		
		System.out.println(getClass()+" calling the getClass() method from the AccountDAO, doing DB operations.\n");
	
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
