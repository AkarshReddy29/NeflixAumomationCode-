import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class workingWithFileUpload {
	WebDriver driver;
	
	@Test
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "F:\\Selenium webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://my.naukri.com/account/createaccount");
		driver.findElement(By.xpath("//button[contains(text(),'I am a Professional')]")).click();
		driver.findElement(By.name("uploadCV")).sendKeys("C:\\Users\\Akarsh\\Desktop\\Akarsh S.pdf");
		Thread.sleep(2000);
		driver.quit();
	}
}

	
	
