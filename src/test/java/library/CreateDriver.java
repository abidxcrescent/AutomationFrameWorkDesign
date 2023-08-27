package library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/*
 * Singleton class is to ensure that driver is instantiated only once
 * throughout the project to keep it synchronized
 */

public class CreateDriver {
	
	private static CreateDriver instance = null;
//	private String browserHandle = null;
//	private static final int IMPLICIT_TIMEOUT = 0;
//	
	private WebDriver driver;
//	private String sessionId;
//	private String sessionBrowser;
//	private String sessionPlatform;
//	private String sessionVersion;
	
	
	
	
	private CreateDriver() {
		
	}
	
	/*
	 * getInstance() gives us the current active driver
	 */
	
	public static CreateDriver getInstance() {
		if(instance == null) {
			instance = new CreateDriver();
		}
		
		return instance;
	}
	
	
	public void setBrowserProperties(String browser, String driverPath) {
		DesiredCapabilities capabilites = null;
		
		if(browser.equalsIgnoreCase("firefox")) {
			capabilites = DesiredCapabilities.firefox();
			
			
			System.setProperty("webdriver.gecko.driver", driverPath+"/firefox.exe");
			/*
			 * Wrapping WebDriver to RobustWebDriver to take care
			 * of SERE.
			 */
			driver = new RobustWebDriver(new FirefoxDriver());
			
			FirefoxOptions fireFoxOptions = new FirefoxOptions();
			fireFoxOptions.merge(capabilites);
			
			fireFoxOptions.addArguments("--start-maximized");
			fireFoxOptions.addArguments("incognito");		
			
		}
		
		else if(browser.equalsIgnoreCase("chrome")) {
			capabilites = DesiredCapabilities.chrome();
	
			System.setProperty("webdriver.chrome.driver", driverPath+"/chromedriver.exe");
			
			/*
			 * Wrapping WebDriver to RobustWebDriver to take care
			 * of SERE.
			 */			
			driver = new RobustWebDriver(new ChromeDriver());
			
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.merge(capabilites);
			
		}
		
		else if(browser.equalsIgnoreCase("ie")) {
			capabilites = DesiredCapabilities.internetExplorer();
			System.setProperty("webdriver.ie.driver", driverPath+"/IEDriverServer.exe");
			
			/*
			 * Wrapping WebDriver to RobustWebDriver to take care
			 * of SERE.
			 */				
			driver = new RobustWebDriver(new InternetExplorerDriver());
			
			InternetExplorerOptions internetExplorerOption = new InternetExplorerOptions();
			internetExplorerOption.merge(capabilites);
		}
		
		else if (browser.equalsIgnoreCase("edge")) {
			capabilites = DesiredCapabilities.edge();
			
			System.setProperty("webdriver.edge.driver", driverPath+"/msedgedriver.exe");
			
			driver = new RobustWebDriver(new EdgeDriver());
			
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.merge(capabilites);
			
		}
		

	}
	
	/*
	 * If we ever want to change the original driver 
	 * we can use setDriver. Not recommended unless parallel
	 * testing is required. 
	 * Multi threading to be added in later versions.
	 */
	public void setBrowserProperties(WebDriver webDriver) {
		driver = webDriver;
		
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	
	public void driverWait(long seconds) {
		try {
			Thread.sleep(TimeUnit.SECONDS.toMillis(seconds));
		} catch (InterruptedException e) {
			System.out.println("To be replaced by log4j statements");
			e.printStackTrace();
		}
	}
	
	public void driverRefresh() {
		
		getDriver().navigate().refresh();
	}
	
	public void closeDriver() {
		try {
			getDriver().quit();
		}
		catch (Exception e) {
			System.out.println("To be replaced by log4j statements");
			e.printStackTrace();
		}
		
		
	}
	
}

