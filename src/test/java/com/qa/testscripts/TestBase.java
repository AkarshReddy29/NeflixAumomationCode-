package com.qa.testscripts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.pageobject.AmazonPages;
import com.qa.pageobject.GooglePages;
import com.qa.pageobject.NetFlixPages;
import com.qa.pageobject.RediffPages;

public class TestBase {
	WebDriver driver;
	RediffPages RediffOR;
	GooglePages GoogleOR;
	SoftAssert SAssert;
	AmazonPages AmazonOR;
	Actions act;
	JavascriptExecutor js;
	NetFlixPages NetFlixOR;
	
	@Parameters({ "Browser", "Url" })
	@BeforeMethod
	
	//Driver and Browser setup
	public void setUp(String Browser, String Url) {
		
		if (Browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "F:\\Selenium webdrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		} else if (Browser.equalsIgnoreCase("edge")) {

			System.setProperty("webdriver.edge.driver", "F:\\Selenium webdrivers\\edgedriver.exe");
			driver = new EdgeDriver();

		} else if (Browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.firefox.driver", "F:\\Selenium webdrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		RediffOR = new RediffPages(driver);
		GoogleOR =new GooglePages(driver);
		AmazonOR =new AmazonPages(driver);
		NetFlixOR =new NetFlixPages(driver);
		driver.get(Url);
		SAssert =new SoftAssert();
	}
	
	//Terminate application
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	//Screen Capture
	public void captureScreenShot(WebDriver driver,String tname) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(Source,target);
		System.out.println("ScreenShot is Captured");
		
	}

}


