package com.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.global.BaseTest;

/*
 *This class contains all the methods which is related to login into application
 *@Author Mohammed Imran 
 * */
public class LoginPage extends BaseTest{
	WebDriver driver;
  
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "a#nav-link-accountList")private WebElement accountAndList;
	@FindBy(css = "a.nav-action-signin-button[rel=nofollow]")private WebElement signinButton;
	@FindBy(css = "input#ap_email")private WebElement emailTextBox;
	@FindBy(css = "input#continue")private WebElement continueButton;
	@FindBy(css="input#ap_password")private WebElement passTextBox;
	@FindBy(css = "input#signInSubmit")private WebElement sigInButton;
	/* This method is used to mouse hover on account and list element */
    public void mouseHoverAccountLists() {
    	utilities.maximizeWindow();
    	log.info("Window is maximized");
    	utilities.moveToElement(accountAndList);
    	log.info("Mousehover action is done");
    }
    /* This method is used to click on sign in button */
    public void clickSignInButton() {
    	utilities.ClickOnElement(signinButton);
    	log.info("Signin button is clicked");
    }
    /* This method is used to send data to email id text box */
    public void enterEmailId() {
    	utilities.sendText(emailTextBox, userName);
    	log.info("Email id is entered");
    }
    /* This method is used to click on continue button */
    public void clickContinueButton() {
    	utilities.ClickOnElement(continueButton);
    	log.info("Continue button is clicked");
    }
    /* This method is used to send data to password text box */
    public void enterPassword() {
    	utilities.sendText(passTextBox, password);
    	log.info("Password is entered");
    }
    /* This method is used to click on password signing button */
    public void clickPassSigninButton() {
    	utilities.ClickOnElement(sigInButton);
    	log.info("Sign in button is clicked");
    }
}
