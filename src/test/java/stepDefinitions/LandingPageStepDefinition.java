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
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	LandingPage landingPage;
	TestContextSetup testContextSetup;
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
		//To avoid object creation every time we are writing object ceration in constructor
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}
	
	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
		
		Assert.assertTrue(landingPage.getTitlelandingPage().contains("GreenKart"));
		
	}
	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		
		//testContextSetup.driver.findElement(By.xpath("//input[@class='search-keyword']")).sendKeys(shortName);
		landingPage.searchItem(shortName);
		Thread.sleep(2000);
		//testContextSetup.landingPageProductName = testContextSetup.driver.findElement(By.xpath("//h4[@class='product-name']")).getText().split("-")[0].trim();
		//testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		String landingPageProductName = landingPage.getProductName();
		
		//System.out.println(landingPageProductName + "is extracted from home page");
		
		if (landingPageProductName != null) {
		    testContextSetup.landingPageProductName = landingPageProductName.split("-")[0].trim();
		    System.out.println(testContextSetup.landingPageProductName + " is extracted from home page");
		} else {
		    System.out.println("Product name is null.");
		}
		
		
		
		
		
	}
	
	@When("^Added \"([^\"]*)\" items of the selected product to cart$")
	public void Added_items_of_the_selected_product_to_cart(String quantity)
	{
		//                            string converted to integer
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
	}
	


}
