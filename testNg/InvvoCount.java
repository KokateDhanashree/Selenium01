package com.testNg;

import org.testng.annotations.Test;

public class InvvoCount {
	
	@Test (invocationCount = 5)
	void count() {
		
		System.out.println("innvo coun!! ");
	}

}
