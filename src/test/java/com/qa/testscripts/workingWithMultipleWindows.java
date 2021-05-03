package com.qa.testscripts;

import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class workingWithMultipleWindows{
	WebDriver driver;
	@Test
	public void multipleWindows() {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rediff.com/");
		driver.findElement(By.linkText("Create Account")).click();
		driver.findElement(By.xpath("//a[contains(text(),'terms and conditions')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'privacy policy')]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iter=windowHandles.iterator();
		
		while (iter.hasNext()) {
			String winId=iter.next();
			WebDriver window=driver.switchTo().window(winId);
			Reporter.log(window.getTitle(),true);
		}
		driver.close();
	}

}
