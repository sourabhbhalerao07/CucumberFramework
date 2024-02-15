package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//we are able to create html, xml, json, junit, extentreport

@CucumberOptions(features="@target/failed_scenarios.txt",glue="stepDefinitions",
monochrome=true,tags="@PlaceOrder or @OffersPage",
//plugin= {//"html:target/cucumber.html","json:target/cucumber.json",
		//"com.avenstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class FailedTestRunner extends AbstractTestNGCucumberTests {
	
	//To run the TC parallely we just need to add below 4 lines of code
	@Override
	@DataProvider(parallel=true)
	public Object [][] scenarios()
	{
		return super.scenarios();
	}

}
