package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	
public WebDriver driver;
	
	public OffersPage(WebDriver driver)
	{
		this.driver = driver;
	}
	//testContextSetup.driver.findElement(By.xpath("//input[@class='search-keyword']")).sendKeys(shortName);
	//By search = By.xpath("//input[@class='search-keyword']");
	By search = By.xpath("//input[@id='search-field']");
	
	//testContextSetup.landingPageProductName = testContextSetup.driver.findElement(By.xpath("//h4[@class='product-name']")).getText().split("-")[0].trim();
	By productName = By.cssSelector("tr td:nth-child(1)");
	
	public void searchItem(String name)
	{
		driver.findElement(search).sendKeys(name);
	}
	
	public void getSearchText()
	{
		driver.findElement(search).getText();
	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}

}
