package com.testNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(com.testNg.ExtentListnerr.class)
public class ExtentReportss {

	WebDriver driver;
	WebDriverWait wait;

	@Test(priority = 1)
	void opnUrl() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@Test(priority =2 , dataProvider = "logData")
	void enterDetails(String email, String pswd) {
	
      WebElement usern =driver.findElement(By.id("user-name"));
      wait.until(ExpectedConditions.visibilityOf(usern));
      usern.sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(pswd);
		driver.findElement(By.id("login-button")).click();
	}

	@DataProvider(indices =0, name = "logData")
	String[][] testData() {

		String[][] data = { { "standard_user", "secret_sauce" }, { "dhanu", "bharath" },

		};

		return data;

	}

	@Test(dependsOnMethods = "enterDetails")
	void tearDown() throws Exception {
		
		System.out.println("yes");
     Thread.sleep(2000);
		driver.quit();
		
	}
}
