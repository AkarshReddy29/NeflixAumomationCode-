package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_RediffCreateAccount_02 extends TestBase{
	
	@Test(priority = 1)
	public void CreateAccount() {
		RediffOR.getCreateAccountLink().click();
		RediffOR.getFullNameTextField().sendKeys("Akarsh");
		RediffOR.getEmailIDTextField().sendKeys("akarsh@test.com");
		RediffOR.getCheckAvailabilityBtn().click();
	}
	
	@Test(priority = 2)
	public void checkNoOfElements() {
		List<WebElement> getallInputFields = RediffOR.getallInputFields();
		int size=getallInputFields.size();
		System.out.println("ToTal input Fields : "+size);
		
		Assert.assertTrue(size<50);
		for (WebElement ele : getallInputFields) {
			String attribute = ele.getAttribute("type");
			Reporter.log(attribute,true);
		}
	}

}
