package com.testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
 
	 public WebDriver driver;

  @BeforeClass
  public void openBrowser() {
	  
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.youtube.com/");
	  
  }
  
  @Test
  public void logIn() {
	  
	  String txt  =  driver.findElement(By.xpath("//input[@id='search']")).getAttribute("aria-label");
//	  driver.findElement(By.name("password")).sendKeys("admin123");
//	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  
	///  String txt = driver.findElement(By.tagName("h5")).getText();
	  System.out.println(txt + " *************");
  }
  
  @AfterClass
  public void closeBrowser() {
	  
	  driver.close();
	  
  }
}
