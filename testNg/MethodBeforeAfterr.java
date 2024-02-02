package com.testNg;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MethodBeforeAfterr {

	
	@BeforeMethod
	void loginn() {
		
		System.out.println("before method");
	}
	
	@Test(priority = 1)
	void searchh() {
		
		System.out.println("search method");
		
	}
	
	@Test(priority =2)
	void advSearch() {
		
		System.out.println("advSearch method");
	}
	
	@AfterMethod
	void logOut() {
		
		System.out.println("after method");
		
	}
	
	
}

