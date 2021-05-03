package com.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utility.ExcelUtility;

public class TC_AmazonSearch_05 extends TestBase{
	
	@Test(dataProvider = "supplyData")
	public void searchItem(String Input1,String Input2) throws InterruptedException {
		
		AmazonOR.getCategotyField(Input1);		
		AmazonOR.getAmazonSearchBox().clear();
		Thread.sleep(1000);
		AmazonOR.getAmazonSearchBox().sendKeys(Input2);
		AmazonOR.getSearchButton().click();
//		Reporter.log(driver.getTitle(),true);
		
		List<WebElement> resultList = AmazonOR.getItems();
//		int count = resultList.size();
//		System.out.println("Size : "+count);
		for (WebElement ele : resultList) {
			Reporter.log(ele.getText(),true);
		}
		List<WebElement> priceList = AmazonOR.getPrice();
		
		for (WebElement ele1 : priceList) {
			Reporter.log(ele1.getText(),true);
		}
		
	}

	@DataProvider
	public String[][] supplyData() throws IOException{
		String xlPath="F:\\Virtusa\\SeleniumAutomation1\\src\\test\\java\\com\\qa\\utility\\Book2.xlsx";
		
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

/*
@DataProvider
public Object[][] supplyData(){
	
	Object[][] data=new Object[3][2];
	
	data[0][0]="Books";
	data[0][1]="Da vinci code";
	data[1][0]="Electronics";
	data[1][1]="Mobile Phones";
	data[2][0]="Furniture";
	data[2][1]="Wooden Tables";
	return data;	
}
*/
