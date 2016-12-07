package com.oracle.test;

import com.oracle.store.CreateUserEntry;
import com.oracle.store.TokenGenerator;
import com.oracle.store.UserSession;

public class ServiceTester {

	public static void main(String[] args) {
		
		String tstr = new TokenGenerator().giveToken();
		UserSession user = new UserSession();
		
		System.out.println("token = "+tstr);
		
		user.set_guid("ADMIN");
		user.set_token(tstr);
		
		CreateUserEntry.testInsertion(user);

	}

}
