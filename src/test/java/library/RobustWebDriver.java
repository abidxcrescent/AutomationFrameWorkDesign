package library;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RobustWebDriver implements WebDriver{
	
	private WebDriver driver;
	
	public RobustWebDriver(WebDriver originalWebDriver) {
		this.driver = originalWebDriver;
	}
	
	@Override
	public void get(String url) {
		this.driver.get(url);
		
	}

	@Override
	public String getCurrentUrl() {
		return this.driver.getCurrentUrl();	
	}

	@Override
	public String getTitle() {
		return this.driver.getTitle();
	}

	@Override
	public List<WebElement> findElements(By by) {
		List<WebElement> elements = new ArrayList<>();
		for(WebElement element: this.driver.findElements(by)) {
			elements.add(new RobustWebElement(element, by, this));
		}
		
		return elements;
	}

	@Override
	public WebElement findElement(By by) {
		return new RobustWebElement(this.driver.findElement(by),by,this);
	}

	@Override
	public String getPageSource() {
		return this.driver.getPageSource();
	}

	@Override
	public void close() {
		this.driver.close();
	}

	@Override
	public void quit() {
		this.driver.quit();
	}

	@Override
	public Set<String> getWindowHandles() {
		return this.driver.getWindowHandles();
	}

	@Override
	public String getWindowHandle() {
		return this.driver.getWindowHandle();
	}

	@Override
	public TargetLocator switchTo() {
		return this.driver.switchTo();
	}

	@Override
	public Navigation navigate() {
		return this.driver.navigate();
	}

	@Override
	public Options manage() {
		return this.driver.manage();
	}
	
}
