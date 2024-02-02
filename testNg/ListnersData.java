package com.testNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ListnersData {

	@Test(priority = 1)
	void test1() {
		
		Assert.assertEquals(1, 1);
		System.out.println("Test 1 !");
	}
	
	@Test(priority =2 )
	void test2() {
		
		Assert.assertEquals('b', 'B');
		System.out.println(" test 2 !");
	}
	
	@Test(priority = 3, dependsOnMethods = "test2")
	void test3() {
		Assert.assertEquals("Dhanu", "Dhanu");
	}
}
