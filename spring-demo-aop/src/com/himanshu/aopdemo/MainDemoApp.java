package com.himanshu.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.himanshu.aopdemo.dao.AccountDAO;
import com.himanshu.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
//		read spring config java class
		AnnotationConfigApplicationContext theContext = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
//		get the account bean from spring container
		AccountDAO theAccountDAO = theContext.getBean("accountDAO",AccountDAO.class);
		
//		get the membership bean from spring container
		MembershipDAO theMembershipDAO = 
				theContext.getBean("membershipDAO",MembershipDAO.class);
		
//		call the business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount);
		
		theAccountDAO.doWork();
		
		theMembershipDAO.addMember();
					
//		close the context
		theContext.close();
		
	}

}
