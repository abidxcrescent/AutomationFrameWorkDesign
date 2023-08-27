package testRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import library.BrowserPropertiesSetup;
import library.Configuration;
import library.SetUp;

@RunWith(Cucumber.class)

@CucumberOptions
				(
						features = ".//Features",
						glue = "stepDefinitions",
						dryRun = false,
						monochrome = true,
						plugin = {"pretty","html:test-outputs"}
				)

public class TestRunner {
	
	
	@BeforeClass
	public static void setUp() {
		new Configuration();
		new SetUp();
	}
	
	@AfterClass
	public static void tearDown() {
		
	}
}
