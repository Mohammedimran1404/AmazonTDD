package com.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.global.BaseTest;

/* This class contains all the methods which is related to logout from the application
 * @Author Mohammed Imran */
public class LogoutPage extends BaseTest {

	WebDriver driver;
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css = "#nav-item-signout")
	private WebElement signoutButton;

	/* This method is used to click on signout button to signout from the application */
	public void clickOnSignOutBtn() {
	 utilities.ClickOnElement(signoutButton);
	 log.info("signout button is clicked");
	}
}
