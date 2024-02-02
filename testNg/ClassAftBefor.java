package com.testNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class ClassAftBefor {

	@BeforeClass
	void logIn() {
		
		System.out.println("Before class login");
	}
	
	@Test
	void searchh() {
		System.out.println("test search");
	}
	@Test
	void advsearch() {
		
		System.out.println("test advSearch");
	}
	
	@AfterClass
	void logout() {
		System.out.println("after class logoout");
	}
	
	@BeforeTest
	void Testb() {
		System.out.println("before test ");
	}
	
	@AfterTest
	void testA() {
		System.out.println("after test");
	}
	
	@BeforeSuite
	void bs() {
		System.out.println(" before suit");
	}
	
	@AfterSuite
	void as() {
		System.out.println("after suitt");
	}
}
