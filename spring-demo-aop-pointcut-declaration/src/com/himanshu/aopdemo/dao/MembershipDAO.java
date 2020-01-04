package com.himanshu.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addMember() {
		System.out.println(getClass() + " : CALLING METHOD FROM MEMBERSHIP DAO CLASSBEAN.\n");
	}
	
}
