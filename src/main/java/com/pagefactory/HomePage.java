package com.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.global.BaseTest;

public class HomePage extends BaseTest {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "input#twotabsearchtextbox")
	private WebElement searchBar;
	@FindBy(css ="span#nav-search-submit-text")
	private WebElement searchBarClick;
	
	/*This method is used to send data to searchbar to search the product */
	public void searchProductInSearchBar()   {
	utilities.sendText(searchBar, mobileName);
	log.info("Mobile name is entered in search bar");
	}
	/*This method is used to click on search bar to search the product*/
	public void clickOnSearchBar()  {
	utilities.ClickOnElement(searchBarClick);
	log.info("Search bar icon is clicked");
	}

}
