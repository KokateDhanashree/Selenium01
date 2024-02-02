package com.testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Dataprvder {

	public WebDriver driver;
	
	@Test
	void setDriver() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.saucedemo.com/");
		
	}
	
	@Test(dataProvider = "logData", dependsOnMethods = "setDriver")
	void testLogin(String email, String paswd) {
		
		driver.findElement(By.id("user-name")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(paswd);
		driver.findElement(By.id("login-button")).click();
		
		String expected = "Swag Labs";
		String actual = driver.getTitle();
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test(dependsOnMethods = "testLogin")
	void tearDown() {
		
		driver.quit();
	}
	
	@DataProvider(name = "logData", indices = {3})
	String[][] logInData() {
		
		String[][] data = 
			{
					{ "standard_user","secret_sauce"  },
					{ "locked_out_user" , "secret_sauce"},
					{ "problem_user", "secret_sauce"},
					{"performance_glitch_user", "secret_sauce"},
	
			};
		
		return data;
	}
	
}
