package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WorkingWithFrames {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "F:\\Selenium webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://docs.oracle.com/javaee/7/api/");
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void frameByIndex() {
		int size=driver.findElements(By.tagName("frame")).size();
		for (int i = 0; i < size; i++) {
			WebDriver frame=driver.switchTo().frame(i);
			String title = frame.getTitle();
			int size2 = frame.findElements(By.tagName("a")).size();
			System.out.println(i+"."+title+" "+size2);
			driver.switchTo().defaultContent();
		}
	}
	
	@Test(priority = 2)
	public void frameByName() {
		WebElement frame=driver.findElement(By.xpath("/html/frameset/frame"));
		String attribute= frame.getAttribute("name");
		Reporter.log(driver.switchTo().frame(attribute).getTitle(),true);
	}
	
	@Test(priority = 3)
	public void frameByElement() {
		WebElement findElement = driver.findElement(By.xpath("//frame[@title='All Packages']"));
		WebDriver frame = driver.switchTo().frame(findElement);
		int size=frame.findElements(By.tagName("a")).size();
		String title=frame.getTitle();
		System.out.println(title+"----->"+size);
	}
}



	