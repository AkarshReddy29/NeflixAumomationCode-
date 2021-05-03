package com.qa.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NetFlixPages {
	WebDriver driver;
	
	
//	Find MailBox
	@FindBy(id = "id_email_hero_fuji")
	WebElement MailBox;
	public WebElement getMailBox() {
		return MailBox;
	}
	
//	Find Start Button
	@FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div[2]/div[1]/div[2]/form/div/div/button/span[1]")
	WebElement startButton;
	public WebElement getStartButton() {
		return startButton;
	}
	
//	Find Continue Button
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	WebElement ContinueButton1;
	public WebElement getContinueButton1() {
		return ContinueButton1;
	}
	
//	Find password Field 
	@FindBy(id = "id_password")
	WebElement PasswordField;
	public WebElement getPasswordField() {
		return PasswordField;
	}
	
//	Find Plan Field
	@FindBy(xpath = "//button[contains(text(),'See the Plans')]")
	WebElement PlanField;
	public WebElement getPlanField() {
		return PlanField;
	}
	
//	Selecting Plan
	@FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div[1]/div[2]/div/div/label[1]/span")
	WebElement SelectPlan;
	public WebElement getSelectPlan() {
		return SelectPlan;
	}

//	Finding Continue button
	@FindBy(xpath = "//html/body/div[1]/div/div/div[2]/div/div[2]/button")
	WebElement ContinueButton2;
	public WebElement getContinueButton2() {
		return ContinueButton2;
	}
	
//	Find Signout Button
	@FindBy(linkText = "Sign Out")
	WebElement SignOut;
	public WebElement SignOut() {
		return SignOut;
	}
	
//	Find SigIn Button
	@FindBy(linkText = "Sign In")
	WebElement SignIn;
	public WebElement getSignIn() {
		return SignIn;
	}
	
//	Find User Login Field
	@FindBy(id = "id_userLoginId" )
	WebElement UserLoginField;
	public WebElement getUserLoginField() {
		return UserLoginField;
	}
	
//	Find User password field
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div/div/div[1]/form/div[2]")
	WebElement UserPasswordField;
	public WebElement getUserPasswordField() {
		return UserPasswordField;
	}
	
//	Find User SigIn button
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div/div/div[1]/form/button")
	WebElement UserSignInButton;
	public WebElement getUserSignInButton() {
		return UserSignInButton;
	}
	
	public void getScroll() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Netflix Originals')]")).click();
		Thread.sleep(2000);
	}
	
//	Driver Initialization 
	public NetFlixPages(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}

//haosgsksiush@shoaib.club




