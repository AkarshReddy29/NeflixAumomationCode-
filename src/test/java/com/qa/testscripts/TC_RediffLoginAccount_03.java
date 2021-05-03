package com.qa.testscripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_RediffLoginAccount_03 extends TestBase{
	
	@Test
	public void login() throws Exception {
		RediffOR.getSignInLink().click();
		boolean contains = driver.getCurrentUrl().contains("login");
		
		if (contains) {
			RediffOR.getUserNameTextBox().sendKeys("Akarsh");
			RediffOR.getPasswordTextBox().sendKeys("Reddy");

			boolean selected = RediffOR.getKeepMeSignedInChkBox().isSelected();
			if(selected) {
				Reporter.log("The check box is selected",true);
				RediffOR.getKeepMeSignedInChkBox().click();
//				System.out.println("HERE");
				Thread.sleep(3000);
				RediffOR.getSignInBtn().click();
			} else {
				Reporter.log("The check box is not selected",true);
			}
		}
		
	}
}
