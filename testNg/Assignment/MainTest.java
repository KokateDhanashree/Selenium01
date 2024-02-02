package com.testNg.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MainTest {

	WebDriver driver;
	JavascriptExecutor scrol;
	
	@Test(priority =1)
	void openb() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://sourcing.hktdc.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@Test(priority =2, dataProvider = "proData")
	void search( String name) {
		
		driver.findElement(By.xpath("//input[@type='search'][@name='search']")).sendKeys(name, Keys.ENTER);
		
	}
	
	@Test(priority =3)
	void down() throws Exception {
		scrol = (JavascriptExecutor) driver;
		scrol.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(2000);
		driver.close();
	}
	
	@DataProvider(name = "proData", indices = 1)
    String[][] pro(){
		String[][] data = {
				{ "cat"	},
				{"dog"}
		};
		return data;
	}

}
