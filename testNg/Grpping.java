package com.testNg;

import org.testng.annotations.Test;

public class Grpping {

	
	@Test(priority =1, groups = { "sanity" ,"regression" })
	void loginByEmail() {
		
		System.out.println(" loginByEmail !!");
	}
	
	@Test(priority =3, groups = {"sanity", "fb"})
	void loginByFb() {
		
		System.out.println(" loginByFb !!");
	}
	
	@Test(priority =2, groups = { "sanity" })
	void loginBytwitter() {
		
		System.out.println(" loginBytwitter !!");
	}
	
	@Test(priority =4, groups = { "sanity" ,"regression" })
	void signUpByEmail() {
		
		System.out.println(" signUpByEmail !!");
	}
	
	@Test(priority =5, groups = "regression ")
	void signUpByFb() {
		
		System.out.println(" signUpByFb !!");

	}
	
	@Test(priority =6, groups = "regression ")
	void signUpBytwitter() {
		

		System.out.println(" signUpBytwitter !!");
	}
	
	@Test(priority =7, groups = { "sanity" ,"regression" })
	void paymentInDoll() {
		
		System.out.println(" paymentInDoll !!");
	}
	
	@Test(priority =8, groups = { "sanity" ,"regression" })
	void paymentInRuppe() {
		
		System.out.println(" paymentInRuppe !!");
	}
	
	@Test(priority =9,  groups = "regression ")
	void paymentInBnk() {
		
		System.out.println(" paymentInBnk !!");
	}
	
}
