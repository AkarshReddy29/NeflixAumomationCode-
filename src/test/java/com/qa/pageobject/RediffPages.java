package com.qa.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffPages {

	WebDriver driver;
	@FindBy(linkText = "Create Account")
	WebElement CreateAccountLink;

	public WebElement getCreateAccountLink() {
		return CreateAccountLink;
	}

	@FindBy(xpath = "//tbody/tr[3]/td[3]/input[1]")
	WebElement FullNameTextField;

	public WebElement getFullNameTextField() {
		return FullNameTextField;
	}

	@FindBy(xpath = "/html/body/center/form/div/table[2]/tbody/tr[7]/td[3]/input[1]")
	WebElement EmailIDTextField;

	public WebElement getEmailIDTextField() {
		return EmailIDTextField;
	}

	@FindBy(className = "btn_checkavail")
	WebElement CheckAvailabilityBtn;

	public WebElement getCheckAvailabilityBtn() {
		return CheckAvailabilityBtn;
	}

	@FindAll(@FindBy(tagName = "input"))
	List<WebElement> allInputFields;

	public List<WebElement> getallInputFields() {
		return allInputFields;
	}

	@FindBy(linkText = "Sign in")
	WebElement SignInLink;

	public WebElement getSignInLink() {
		return SignInLink;
	}

	@FindBy(id = "login1")
	WebElement UserNameTextBox;

	public WebElement getUserNameTextBox() {
		return UserNameTextBox;
	}

	@FindBy(id = "password")
	WebElement PasswordTextBox;

	public WebElement getPasswordTextBox() {
		return PasswordTextBox;
	}

	@FindBy(id = "remember")
	WebElement KeepMeSignedInChkBox;

	public WebElement getKeepMeSignedInChkBox() {
		return KeepMeSignedInChkBox;
	}

//	@FindBy(xpath = "/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/input[2]")
	@FindBy(name="proceed")
	WebElement SignInBtn;

	public WebElement getSignInBtn() {
		return SignInBtn;
	}
	
	
	public RediffPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
