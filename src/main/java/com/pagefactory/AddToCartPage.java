package com.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.global.BaseTest;


/*
 *This class contains all the methods which is related to adding a product to cart
 *and checking the product value and add to cart value
 *@Author Mohammed Imran */
public class AddToCartPage extends BaseTest {
	WebDriver driver;
	public AddToCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(css="input#add-to-cart-button")
		private WebElement addToCart;
		@FindBy(css="div[id=corePriceDisplay_desktop_feature_div] span[class=a-price-whole]")
	    private WebElement productprice;
		@FindBy(css = "div[id=corePriceDisplay_desktop_feature_div] span.a-price-symbol")
		private WebElement currencySymbol;
		@FindBy(css="span#attach-accessory-cart-subtotal")
		private WebElement addToCartPrice;
		@FindBy(css = "[id=attach-sidesheet-view-cart-button]")
        private WebElement cart;
        @FindBy(css = "input[value=Delete]")
        private WebElement deleteBtn;

	/* This method is used to click on add to cart button */
   public void clickOnAddTOCart() {
	   try {
	   utilities.ClickOnElement(addToCart);
	   log.info("Add to cart is clicked");
	   }
	   catch(WebDriverException e) {
		   log.error("An error occurred while clicking on Add to cart: "+ e.getMessage()); 
	   }
   }
   /* This method is used to check the product price and add to cart price */
   public void validatingProductPrice() {
	   utilities.expicitWaitForVisibilityOfElement(addToCartPrice, 10);
		try {
	   String str_intendentPrice= validations.getText(currencySymbol)+validations.getText(productprice)+".00";
	   String str_realizedPrice=validations.getText(addToCartPrice);
	   validations.verifyTwoValues(str_realizedPrice, str_intendentPrice);
	   log.info("validated price of product"); 
   }
	   catch(WebDriverException e1) {
		 log.error("An error occured while validating the product price"+ e1.getMessage());  
	 
	   }
   }
   /*This method is used to click on cart button after the price is validated*/
   public void clickOnCartButton() {
	   try {
	   utilities.ClickOnElement(cart);
	   }
	   catch(WebDriverException e) {
		 log.error("An error occured while clicking on cart button"+e.getMessage());
		   
	   }
   }
   /*This method is used to click on delete button to remove the product from cart*/
   public void clickOnDeleteButton() {
	   utilities.ClickOnElement(deleteBtn);
   }
   
}
   









