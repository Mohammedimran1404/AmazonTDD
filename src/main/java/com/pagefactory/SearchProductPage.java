package com.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.global.BaseTest;
/*
 *This class contains all the methods which is related to searching a product
 *and moving curser on the product and validating zoom image is visible after
 *removing the curser from the product zoom image should not be visible
 *@Author Mohammed Imran 
 * */
public class SearchProductPage extends BaseTest{
	WebDriver driver;
	public SearchProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "input#twotabsearchtextbox")
	private WebElement searchBar;
	@FindBy(css ="span#nav-search-submit-text")
	private WebElement searchBarClick;
    @FindBy(css = "img[alt='Redmi 9A Sport (Carbon Black, 2GB RAM, 32GB Storage) | 2GHz Octa-core Helio G25 Processor | 5000 mAh Battery']")
	private WebElement image;
    @FindBy(css = "img#landingImage")
    private WebElement imageMousehover;
    @FindBy(css = "div#zoomWindow")
    private WebElement zoomImage;
	
	/* This method is used to click on product and the product is openedis other tab*/
    public void clickOnImage()  {
	utilities.ClickOnElement(image);
	log.info("Product is clicked");
	utilities.windowHandle(title);
	log.info("Window is handle");
	}
	/* This method is used to mouse hover on the image and the image get zoom */
	public void mousehoverOnImage() {	
	utilities.moveToElement(imageMousehover);
	log.info("Mouse hover is done to the product");
	}
	/*This method is used to validate zoom image and validate
	 *zoom image after the curser is moved */
	public void validatingImageVisibilityAndInvisibility() {
	validations.validatingElementVisibility(zoomImage);
	log.info("Image is validated");
	utilities.moveToElement(zoomImage);
	log.info("Curser is moved to other product");
	validations.validatingElementInvisibility(zoomImage);
	log.info("Zoomimage is not present after curser is move to other element");
	}
}






//img[alt$=\"Redmi 9A Sport (Coral Green, 2GB RAM, 32GB Storage)\"]
