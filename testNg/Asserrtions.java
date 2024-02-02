package com.testNg;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Asserrtions {

	
	@Test
	void asrr() {
		
		int a=10;
		int b=10;
		
		Assert.assertEquals(a==b, true, " not equal");
		Assert.assertEquals(a>b, false);
		
		String ab= "abc";
		String ba = "abc";
		
		Assert.assertEquals(ab, ba);
		Assert.assertNotEquals(ab, b);
		
		if(true) {
			Assert.assertTrue(true);
		}else
		{
			Assert.fail();
		}
	}
	
	@Test
	void hardAsser() {
		
		System.out.println(" hard assert start");
		Assert.assertEquals(1, 10);
		System.out.println(" hard assert done");
	}
	
	@Test
	void softAssr() {
		
		System.out.println("soft assert start");
		
		SoftAssert soft = new SoftAssert();
		
		soft.assertEquals(1, 2);
		
		System.out.println("1");
		soft.assertEquals(1, 2);
		
		System.out.println("2");
		
		soft.assertAll();
	}
}
