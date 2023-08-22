package com.testscripts;

import org.testng.annotations.Test;
import com.global.BaseTest;


public class TC_002AddToCartPage extends BaseTest{
	
	@Test
	public void addToCartTest() {
		homepage.searchProductInSearchBar();
		homepage.clickOnSearchBar();
		searchproduct.clickOnImage();
		addtocart.clickOnAddTOCart();
		addtocart.validatingProductPrice();
		addtocart.clickOnCartButton();
		addtocart.clickOnDeleteButton();
		
	}
}
