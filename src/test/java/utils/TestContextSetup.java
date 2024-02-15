package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

//what variables & properties we want to share to another step definotion that things we can share here

public class TestContextSetup {
	
	public WebDriver driver;
	public String landingPageProductName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	
	public TestContextSetup() throws IOException
	{
		//testBase = new TestBase();
		//pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
		//genericUtils = new GenericUtils(testBase.WebDriverManager());
		
		
		testBase = new TestBase();
        driver = testBase.WebDriverManager();
        pageObjectManager = new PageObjectManager(driver);
        genericUtils = new GenericUtils(driver);
		
		
	}
	
	
}
