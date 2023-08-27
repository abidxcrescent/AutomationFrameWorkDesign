package library;

/*
 * This is the class where we setup and select browser
 * This is the child class to Configuration
 */

public class BrowserPropertiesSetup{
	
	public static String browserPath = Configuration.driverPath;
	public static String browserName = Configuration.browser;
	
	/*
	 * This is the class where DRIVER IS INITIALIZED
	 * This is the standard method to create driver through out the project
	 */
	public static CreateDriver instance = CreateDriver.getInstance();
	
	/*
	 * This method set up browser and system properties
	 * A new browser window is opened here
	 */
	public static final void setUpBrowser() throws IllegalAccessException {
		System.out.println("In method");
		if(browserName.equalsIgnoreCase("chrome")) {
			instance.setBrowserProperties(browserName, browserPath);
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			instance.setBrowserProperties(browserName, browserPath);
		}
		
		else if(browserName.equalsIgnoreCase("ie")) {
			instance.setBrowserProperties(browserName, browserPath);
		}
		
		else if(browserName.equalsIgnoreCase("edge")){
			instance.setBrowserProperties(browserName, browserPath);
		}
		
		else {
			throw new IllegalAccessError("Problem in setting up a browser");
		}
		
	}
	
	
}
