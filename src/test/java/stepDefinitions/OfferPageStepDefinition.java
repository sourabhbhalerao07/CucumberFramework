package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {

	public String offerPageProductName;
    TestContextSetup testContextSetup;
    PageObjectManager pageObjectManager;
	
	public OfferPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
	}

	@Then("^user searched for (.+) in offers page$")
	public void user_searched_for_in_offers_page(String shortName) throws InterruptedException {
		
		switchToOfferPage();
		OffersPage offersPage = new OffersPage(testContextSetup.driver);
		//LandingPage landingPage = new LandingPage(testContextSetup.driver);
		//pageObjectManner = new PageObjectManager(testContextSetup.driver);
		//LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		//testContextSetup.driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(shortName);
		
		//landingPage.selectTopDealsPage();
		offersPage.searchItem(shortName);
		Thread.sleep(2000);
		//offerPageProductName = testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		offerPageProductName = offersPage.getProductName();
		
		
	}
	
	public void switchToOfferPage()
	{
		//if swithched to offer page->skip below part
		//if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
		//pageObjectManager = new PageObjectManager(testContextSetup.driver);
		//testContextSetup.driver.findElement(By.xpath("//a[text() = 'Top Deals']")).click();
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
		testContextSetup.genericUtils.SwitchWindowToChild();
	}
	@Then("validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
		
	}


}
