package com.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utility.ExcelUtility;

//Format1
/*public class TC_GoogleScript_04 extends TestBase {
	
	@Test(dataProvider = "getData")
	public void searchItem(String Input) throws Exception {
		
		GoogleOR.getSearchBox().clear();
		GoogleOR.getSearchBox().sendKeys(Input);
		Thread.sleep(3000);
		List<WebElement> suggestions = GoogleOR.getSuggestions();
		
		for (WebElement ele : suggestions) {
			Reporter.log(ele.getText(), true);
		}
		
		GoogleOR.getSearchBotton().submit();
		boolean Title=driver.getTitle().contains(Input);
		Assert.assertTrue(Title);
		
	}
	@DataProvider
	public Object[][] getData(){
		Object[][] data=new Object[3][1];
		
		data[0][0]="Automation Testing";
		data[1][0]="Performance Testing";
		data[2][0]="API Testing";
		return data;
	}

} */
public class TC_GoogleScript_04 extends TestBase {
	
	@Test(dataProvider = "getData")
	public void searchItem(String Input) throws Exception {
		
		GoogleOR.getSearchBox().clear();
		GoogleOR.getSearchBox().sendKeys(Input);
		Thread.sleep(3000);
		List<WebElement> suggestions = GoogleOR.getSuggestions();
		
		for (WebElement ele : suggestions) {
			Reporter.log(ele.getText(), true);
		}
		
		GoogleOR.getSearchBox().submit();
		boolean Title=driver.getTitle().contains(Input);
		Assert.assertTrue(Title);
		
	}
	@DataProvider
	public String[][] getData() throws IOException{
		String xlPath="F:\\Virtusa\\SeleniumAutomation1\\src\\test\\java\\com\\qa\\utility\\Book1.xlsx";
		
		String xlSheet = "Sheet1";
		
		int rowCount =ExcelUtility.getRowCount(xlPath, xlSheet);
		
		int cellCount=ExcelUtility.getCellCount(xlPath, xlSheet, rowCount);
		
		String[][] data=new String[rowCount][cellCount];
		
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				data[i-1][j] = ExcelUtility.getcellData(xlPath, xlSheet, i, j);

			}
		}

		return data;
		
	}
}