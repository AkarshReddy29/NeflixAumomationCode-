package com.qa.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonPages {

	WebDriver driver;

	@FindBy(name = "url")

	WebElement category;

	public void getCategotyField(String item) {
		Select s = new Select(category);
		s.selectByVisibleText(item);

	}

	@FindBy(id = "twotabsearchtextbox")
	WebElement AmazonSearchBox;

	public WebElement getAmazonSearchBox() {

		return AmazonSearchBox;
	}

	@FindBy(id = "nav-search-submit-button")
	WebElement SearchButton;

	public WebElement getSearchButton() {

		return SearchButton;
	}

	@FindAll(@FindBy(xpath = "//a[@class='a-link-normal a-text-normal']"))
	List<WebElement> Items;

	public List<WebElement> getItems() {

		return Items;
	}

	@FindAll(@FindBy(xpath = "//span[@data-a-color='price']"))
	List<WebElement> priceList;

	public List<WebElement> getPrice() {

		return priceList;
	}

	@FindAll(@FindBy(xpath = "//body[1]/div[1]/div[5]/div[4]/ul/li/a"))
	List<WebElement> countryList;

	public List<WebElement> getCountryList() {
		return countryList;
	}

	public AmazonPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
