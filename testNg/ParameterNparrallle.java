package com.testNg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParameterNparrallle {

	WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser", "url"})
	void opn(String brow, String urlapp) {
		
		if(brow.equals("ch"))
		{
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		}else if(brow.equals("fire"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get(urlapp);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@Test
	void title() {
		
		String title =driver.getTitle();
		System.out.println(title);
	}
	
	@AfterClass
	void clse() throws Exception {
		
		Thread.sleep(2000);
		driver.close();
	}
	
}
