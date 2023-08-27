package library;

import org.openqa.selenium.WebDriver;

import pageObject.LoginPage;

/*
 * This is the class where the first few common steps will be initialized
 */

public class SetUp {
	
	/*
	 * This is the local driver instance it will be linked to current driver
	 */
	
	public SetUp() {
		try {
			BrowserPropertiesSetup.setUpBrowser();
			/*
			 * This is where we link it to current driver
			 * BrowserPropertiesSetup.getDriver() will return the current driver
			 */
			//driver = BrowserPropertiesSetup.getDriver();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		CreateDriver instance = CreateDriver.getInstance();
		WebDriver driver = instance.getDriver();
		
		System.out.println("hello");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.navigate().to(Configuration.url);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName();
		loginPage.setPassword();
		loginPage.clickSubmit();
		System.out.println("Helllo");
		
	}
	
	

}
