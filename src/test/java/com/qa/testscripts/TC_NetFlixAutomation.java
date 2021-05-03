package com.qa.testscripts;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utility.ExcelUtility;

public class TC_NetFlixAutomation extends TestBase {
	
	

	@Test(priority=1,dataProvider = "supplyData")
	public void createAccount(String Input1, String Input2) throws Exception {
		captureScreenShot(driver,"createAccount");
		NetFlixOR.getMailBox().sendKeys(Input1);
		NetFlixOR.getStartButton().click();
		Thread.sleep(2000);
		NetFlixOR.getPasswordField().sendKeys(Input2);
		Thread.sleep(1000);
		NetFlixOR.getContinueButton1().click();
		Thread.sleep(1000);
		NetFlixOR.getPlanField().click();
		Thread.sleep(2000);
		NetFlixOR.getSelectPlan().click();
		Thread.sleep(2000);
		NetFlixOR.getContinueButton2().click();
		Thread.sleep(1000);
		NetFlixOR.SignOut();
		Thread.sleep(1000);
	}
		
	@Test(priority=2)
	public void Scroll() throws Exception {

//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,1500)");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//span[contains(text(),'Netflix Originals')]")).click();
//		Thread.sleep(2000);
		NetFlixOR.getScroll();
		captureScreenShot(driver,"Scroll");
		
	}
	
	@DataProvider
	public String[][] supplyData() throws IOException {
		String xlPath = "F:\\Virtusa\\SeleniumAutomation1\\src\\test\\java\\com\\qa\\utility\\Book3.xlsx";

		String xlSheet = "Sheet1";

		int rowCount = ExcelUtility.getRowCount(xlPath, xlSheet);

		int cellCount = ExcelUtility.getCellCount(xlPath, xlSheet, rowCount);

		String[][] data = new String[rowCount][cellCount];

		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				data[i - 1][j] = ExcelUtility.getcellData(xlPath, xlSheet, i, j);

			}
		}

		return data;
	}
}

/*
 * @Test public void Signin() throws Exception { NetFlixOR.getSignIn().click();
 * // Thread.sleep(2000); NetFlixOR.getUserLoginField().sendKeys("akarsh");
 * Thread.sleep(2000); NetFlixOR.getUserLoginField().sendKeys("123456");
 * NetFlixOR.getUserSignInButton().click(); }
 */


