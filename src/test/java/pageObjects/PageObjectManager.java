package pageObjects;

import org.openqa.selenium.WebDriver;

//We have to avoid object creation process in step definition thats why we are creating this class
//And every page we have to add here
public class PageObjectManager {
	
	public LandingPage  landingPage;
	public OffersPage offersPage;
	public CheckOutPage checkOutPage;
	public WebDriver driver;
	
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public LandingPage getLandingPage()
	{
		landingPage = new LandingPage(driver);
		return landingPage;
	}
	
	public OffersPage OffersPage()
	{
		offersPage = new OffersPage(driver);
		return offersPage;
	}
	
	public CheckOutPage getCheckOutPage()
	{
		checkOutPage = new CheckOutPage(driver);
		return checkOutPage;
	}
	
	  
	

}
