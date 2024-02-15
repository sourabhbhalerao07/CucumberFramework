package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException
	{
		//below code is to take browser and url values from properties file 
		//We are giving path dynamically if our code will run any other system or cmd or pipeline it should work fine
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAUrl");
		String browser_Properties = prop.getProperty("browser");
		String browser_maven = prop.getProperty("browser");
		
		String browser = browser_maven!=null ?  browser_maven : browser_Properties;
		
		
		
		if(driver == null) 
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
				//System.setProperty("webdriver/chromedriver", "C:\\Users\\Sourabh\\Downloads\\chromedriver_win32 (4).exe");
				//We are giving path dynamically if our code will run any other system or cmd or pipeline it should work fine
				System.setProperty("webdriver/chromedriver", System.getProperty("user.dir")+"//src//test//resources\\chrome");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			}
			
			if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver/chromedriver", "D:\\Driver\\geckodriver-v0.34.0-win-aarch64.exe");
				driver = new ChromeDriver();
			}
			
			//Globally declared implicit wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get(url);
		}
		return driver;
	}
	

}
