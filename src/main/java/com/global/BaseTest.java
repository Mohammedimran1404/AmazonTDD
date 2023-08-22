package com.global;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.pagefactory.AddToCartPage;
import com.pagefactory.HomePage;
import com.pagefactory.LoginPage;
import com.pagefactory.LogoutPage;
import com.pagefactory.SearchProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
 This Class contains basic configuration annotations
 for common functionalities like launch browser and quit etc
  @Author MOhammed Imran
  * */
public class BaseTest {
	
   public static  WebDriver driver;
   public PropertyFile propertyfile= new PropertyFile();
   public CreateLog log = new CreateLog();
   public DateTime datetime = new DateTime();
   public  UtilFunctions utilities= new UtilFunctions(driver);
   public Validations validations=new Validations();
   public ReadExcellFile readexcell=new ReadExcellFile();
   public  LoginPage loginpage;
   public HomePage homepage;
   public SearchProductPage searchproduct;
   public AddToCartPage addtocart;
   public LogoutPage logoutpage;
   String url=propertyfile.getApplicationUrl();
   String browser=propertyfile.getApplicationBrowser();
   public String userName=propertyfile.getApplicationUserName();
   public String password=propertyfile.getApplicationPassword();
   public String mobileName=readexcell.readDataFromExcel("SearchProduct", 0, 1);
   public String title=readexcell.readDataFromExcel("SearchProduct", 1, 1);
   
	@BeforeClass
	public void setUp() {
		switch (browser) {
		case "chrome":
			chromeBrowser();
			break;
		case "firefox":
			firefoxBrowser();
			break;

		case "edge":
			edgeBrowser();
			break;
		case "safari":
			safariBrowser();
			break;
		default:
			error();
   }
		
  }
	@BeforeMethod
	public void login() {
    loginpage= new LoginPage(driver);
    homepage= new HomePage(driver);
    addtocart= new AddToCartPage(driver);
    searchproduct = new SearchProductPage(driver);
    logoutpage= new LogoutPage(driver);
    
    
	loginpage.mouseHoverAccountLists();
	loginpage.clickSignInButton();
	loginpage.enterEmailId();
	loginpage.clickContinueButton();
	loginpage.enterPassword();
	loginpage.clickPassSigninButton();
	}
	@AfterMethod
	public void logOut() {
	loginpage.mouseHoverAccountLists();
	logoutpage.clickOnSignOutBtn();
	}
	@AfterClass
	public void quit() {
		driver.quit();
		log.info("Driver is quit");
	}
	
	public void chromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		log.info("ChromeBrowser is launched");
		url();
		
	}
	public void edgeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver= new EdgeDriver();
		log.info("EdgeBrowser is launched");
		url();
	}
	public void firefoxBrowser() {
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
		log.info("FirefoxBrowser is launched");
		url();
	}
	public void safariBrowser() {
		WebDriverManager.safaridriver().setup();
		driver=new SafariDriver();
		log.info("SafariBrowser is launched");
		url();
	}
	public void error() {
		System.err.println("unknow browser");
		log.info("Unknown browser");
	}
	public void url() {
	driver.get(url);
	log.info("URL is launched");
	
	}
	/*return the browser name*/
	public String browsername() {
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		return browserName;
	}
	/*return the browser version*/
	public String browserversion() {
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserversion = cap.getBrowserVersion().toString();
		return browserversion;
	}
}
