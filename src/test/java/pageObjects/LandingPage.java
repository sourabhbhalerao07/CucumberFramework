package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	//testContextSetup.driver.findElement(By.xpath("//input[@class='search-keyword']")).sendKeys(shortName);
	By search = By.xpath("//input[@type='search']");

	
	//testContextSetup.landingPageProductName = testContextSetup.driver.findElement(By.xpath("//h4[@class='product-name']")).getText().split("-")[0].trim();
	By productName = By.xpath("//h4[@class='product-name']");
	
	
	//testContextSetup.driver.findElement(By.xpath("//a[text() = 'Top Deals']")).click();
	By topDeals = By.xpath("//a[text() = 'Top Deals']");
	
	By increment = By.xpath("//a[@class='increment']");
	
	By addToCart = By.cssSelector(".product-action button");
	
	
	public void searchItem(String name)
	{
		driver.findElement(search).sendKeys(name);
	}
	
	public void getSearchText()
	{
		driver.findElement(search).getText();
	}
	
	public void incrementQuantity(int quantity)
	{
		int i = quantity-1;
		while(i>0)
		{
			driver.findElement(increment).click();
			i--;
		}
	}
	
	public void addToCart()
	{
		driver.findElement(addToCart).click();
	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();
		
	}
	
	public void selectTopDealsPage()
	{
		driver.findElement(topDeals).click();
	}
	
	public String getTitlelandingPage()
	{
		return driver.getTitle();
	}
	
	
	
	

}
