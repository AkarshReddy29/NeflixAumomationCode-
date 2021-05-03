package com.qa.testscripts;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class WorkingWithScreenshots {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "F:\\Selenium webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void ElementScreenshot() throws Exception {
		String name = "Amazonlogo";
		WebElement Logo = driver.findElement(By.id("nav-logo-sprites"));
		File Source = Logo.getScreenshotAs(OutputType.FILE);
		String Dest = System.getProperty("user.dir") + "/Screenshots/" + name + System.currentTimeMillis() + ".png";
		FileUtils.copyFile(Source,new  File(Dest));
	}
	
	@Test(priority = 2)
	public void DriverScreenshot() throws IOException {
		String name = "AmazonPage";
		TakesScreenshot SShot=(TakesScreenshot)driver;
		File Source = SShot.getScreenshotAs(OutputType.FILE);
		String Dest = System.getProperty("user.dir") + "/Screenshots/" + name + System.currentTimeMillis() + ".png";
		FileUtils.copyFile(Source,new  File(Dest));
	
	}
	
	@Test(priority = 3)
	public void FullpageScreenShot() throws Exception {
		String name = "AmazonFullPage";
		AShot FullScreen=new AShot();
		Screenshot takeScreenshot=FullScreen.shootingStrategy(ShootingStrategies.viewportPasting(200)).takeScreenshot(driver);
			
		String Dest = System.getProperty("user.dir") + "/Screenshots/" + name + System.currentTimeMillis() + ".png";
		File FinalDestination = new File(Dest);
		ImageIO.write(takeScreenshot.getImage(), "png", FinalDestination);
	}

}
