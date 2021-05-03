package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_AmazonCountries extends TestBase{
	@Test
	public void list() {
		List<WebElement> List = AmazonOR.getCountryList();
		
		for (WebElement ele : List) {
			Reporter.log(ele.getText()+"--"+ele.getAttribute("href"),true);	
		}
	}
}
