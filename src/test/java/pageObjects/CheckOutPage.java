package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
	
	public WebDriver driver;
	
	public CheckOutPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By cartbag = By.xpath("//img[@alt='Cart']");
	
	By checkOutButton = By.xpath("//button[@type='button'][contains(text(),'PROCEED')]");
	
	By promoBtn = By.xpath("//button[@class='promoBtn']");
	
	By placeOrder = By.xpath("//button[text()='Place Order']");
	
	
	public void checkOutItems()
	{
		driver.findElement(cartbag).click();
		driver.findElement(checkOutButton).click();
	}
	
	public boolean VerifyPromoBtn()
	{
		return driver.findElement(promoBtn).isDisplayed();
	}
	
	public boolean VerifyPlaceOrder()
	{
		return driver.findElement(placeOrder).isDisplayed();
	}
	
	
	
	

}
