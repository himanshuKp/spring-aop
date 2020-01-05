package com.himanshu.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.himanshu.aopdemo.dao.AccountDAO;
public class MainDemoApp {

	public static void main(String[] args) {
		
//		read spring config java class
		AnnotationConfigApplicationContext theContext = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
//		get the account bean from spring container
		AccountDAO theAccountDAO = theContext.getBean("accountDAO",AccountDAO.class);
		/*
		 * // get the membership bean from spring container MembershipDAO
		 * theMembershipDAO = theContext.getBean("membershipDAO",MembershipDAO.class);
		 * 
		 * // call the business method Account myAccount = new
		 * Account("Himanshu","Platinum"); // myAccount.setName("Himanshu"); //
		 * myAccount.setLevel("Platinum"); theAccountDAO.addAccount(myAccount);
		 * 
		 * theAccountDAO.doWork();
		 * 
		 * theAccountDAO.setAddress("Gzb"); theAccountDAO.setName("himanshu");
		 * theAccountDAO.getAddress(); theAccountDAO.getName();
		 */
		
//		get the list of all accounts stored
//		add the following into try/catch to simulate exception thrown
		
		List<Account> theAccounts = null;
				
		try {
			boolean flag = true;
			theAccounts = theAccountDAO.findAccounts(flag);
		}
		catch(Exception e) {
			System.out.println("\nException is thrown in main method: " +e);
		}
		
		System.out.println("\nMain method:");
		System.out.println("------------------");
		System.out.println(theAccounts+"\n");
		
//		theMembershipDAO.addMember();

//		close the context
		theContext.close();
		
	}

}
