package com.qa.testscripts;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class ScrollBy {
	
	//WebDriver driver;
	
    @Test
    public void amazonScroll() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "F:\\Selenium webdrivers\\chromedriver.exe");
    	WebDriver  driver = new ChromeDriver();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Launch the application		
        driver.get("https://www.netflix.com/");

       	
        driver.manage().window().maximize();

        	
        js.executeScript("window.scrollBy(0,1000)");
        
        driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[1]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("jobs"));
        System.out.println("Test Passed!");
        
      
    }
}
