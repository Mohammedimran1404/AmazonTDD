package com.testscripts;
import org.testng.annotations.Test;
import com.global.BaseTest;

public class TC_001SearchProductPage extends BaseTest {
	@Test
	public void searchMobileTest() {
    homepage.searchProductInSearchBar();
    homepage.clickOnSearchBar();
    searchproduct.clickOnImage();
    searchproduct.mousehoverOnImage();
    searchproduct.validatingImageVisibilityAndInvisibility();
 }
    }
