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
import pageObjects.CheckOutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckOutPageStepDefinition {
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	public CheckOutPage checkOutPage;
	TestContextSetup testContextSetup;
	
	public CheckOutPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
		this.checkOutPage = testContextSetup.pageObjectManager.getCheckOutPage();
	}
	
	
	
	@Then("Verify product user has ability to enter promo code and place the order")
	public void verify_product_user_has_ability_to_enter_promo_code_and_place_the_order() {
		Assert.assertTrue(checkOutPage.VerifyPromoBtn());
		Assert.assertTrue(checkOutPage.VerifyPlaceOrder());
	}
	
	
	
	@Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
	
	public void user_proceeds_to_checkout_and_validate_the_beet_items_in_checkout_page(String name) throws InterruptedException {
		checkOutPage.checkOutItems();
		Thread.sleep(2000);
	}


}
