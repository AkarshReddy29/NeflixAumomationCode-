package com.qa.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePages {
	WebDriver driver;

	@FindBy(name = "q")

	WebElement SearchBox;

	public WebElement getSearchBox() {

		return SearchBox;
	}
//	/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input
//	/html/body/div[4]/form/div[1]/div[1]/div[2]/div/div[2]/input
/*	@FindBy(xpath="/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")
	WebElement SearchBotton;

	public WebElement getSearchBotton() {

		return SearchBotton;
	}
*/
	
	@FindAll(@FindBy(tagName = "ul"))
	List<WebElement> Suggestions;

	public List<WebElement> getSuggestions() {

		return Suggestions;
	}
	
	public GooglePages(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
