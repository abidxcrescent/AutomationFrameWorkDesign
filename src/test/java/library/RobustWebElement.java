package library;

/*
 * This is the RobustWebElement class where Stale Element Exception has been taken care of.
 * It is done by just trying again for MAX_RETRIES number of time.
 * If the issue still persist after MAX_RETRIES then SERE will be thrown
 * SERE is StaleElementReferenceException
 */

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class RobustWebElement implements WebElement{
	private WebElement originalElement;
	private RobustWebDriver driver;
	private By by;
	private static final int MAX_RETRIES = 10;
	
	public RobustWebElement(WebElement element, By by, RobustWebDriver originalDriver) {
		this.originalElement = element;
		this.by = by;
		this.driver = originalDriver;
	}
	
	/*
	 * This method re-looks for the element in the DOM
	 * 
	 */
	private void refreshElement() {
		this.originalElement = driver.findElement(by);
	}
	
	/*
	 * The idea is to try and look for element for MAX_RETRIES.
	 * If the element is found everything continues same.
	 * If not then SERE is thrown anyways.
	 */
	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		int retries = 0;
		
		while(retries < MAX_RETRIES) {
			try {
				return this.originalElement.getScreenshotAs(target);
				
			}
			catch(StaleElementReferenceException e) {
				refreshElement();
			}
			retries++;
		}
		
		throw new StaleElementReferenceException
		(String.format("Element is still stale after % s tries", MAX_RETRIES));
	}

	@Override
	public void click() {
		int retries = 0;
		while(retries < MAX_RETRIES) {
			try {
				this.originalElement.click();
				return;
			}
			catch(StaleElementReferenceException e) {
				refreshElement();
			}
			retries++;
		}
		
		throw new StaleElementReferenceException
		(String.format("Element is still stale after %s retries", MAX_RETRIES));
	}

	@Override
	public void submit() {
		int retries = 0;
		
		while(retries < MAX_RETRIES) {
			try {
				this.originalElement.submit();
				return;
			}
			catch(StaleElementReferenceException e) {
				refreshElement();
			}
			retries++;
		}
		
		throw new StaleElementReferenceException
		(String.format("Element is still stale after % s tries", MAX_RETRIES));
		
	}

	@Override
	public void sendKeys(CharSequence... keysToSend) {
		int retries = 0;
		
		while(retries < MAX_RETRIES) {
			try {
				this.originalElement.sendKeys(keysToSend);
				return;
			}
			catch(StaleElementReferenceException e) {
				refreshElement();
			}
			retries++;
		}
		
		throw new StaleElementReferenceException
		(String.format("Element is still stale after % s tries", MAX_RETRIES));
		
	}
		

	@Override
	public void clear() {
		int retries = 0;
		
		while(retries < MAX_RETRIES) {
			try {
				this.originalElement.clear();
				return;
			}
			catch(StaleElementReferenceException e) {
				refreshElement();
			}
			retries++;
		}
		
		throw new StaleElementReferenceException
		(String.format("Element is still stale after % s tries", MAX_RETRIES));
		
	}

	@Override
	public String getTagName() {
		int retries = 0;
		
		while(retries < MAX_RETRIES) {
			try {
				return this.originalElement.getTagName();
				
			}
			catch(StaleElementReferenceException e) {
				refreshElement();
			}
			retries++;
		}
		
		throw new StaleElementReferenceException
		(String.format("Element is still stale after % s tries", MAX_RETRIES));
	}

	@Override
	public String getAttribute(String name) {
		int retries = 0;
		
		while(retries < MAX_RETRIES) {
			try {
				return this.originalElement.getAttribute(name);
				
			}
			catch(StaleElementReferenceException e) {
				refreshElement();
			}
			retries++;
		}
		
		throw new StaleElementReferenceException
		(String.format("Element is still stale after % s tries", MAX_RETRIES));
	}

	@Override
	public boolean isSelected() {
		int retries = 0;
		
		while(retries < MAX_RETRIES) {
			try {
				return this.originalElement.isSelected();
				
			}
			catch(StaleElementReferenceException e) {
				refreshElement();
			}
			retries++;
		}
		
		throw new StaleElementReferenceException
		(String.format("Element is still stale after % s tries", MAX_RETRIES));
	}

	@Override
	public boolean isEnabled() {
		int retries = 0;
		
		while(retries < MAX_RETRIES) {
			try {
				return this.originalElement.isEnabled();
				
			}
			catch(StaleElementReferenceException e) {
				refreshElement();
			}
			retries++;
		}
		
		throw new StaleElementReferenceException
		(String.format("Element is still stale after % s tries", MAX_RETRIES));
	}

	@Override
	public String getText() {
		int retries = 0;
		
		while(retries < MAX_RETRIES) {
			try {
				return this.originalElement.getText();
				
			}
			catch(StaleElementReferenceException e) {
				refreshElement();
			}
			retries++;
		}
		
		throw new StaleElementReferenceException
		(String.format("Element is still stale after % s tries", MAX_RETRIES));
	}

	@Override
	public List<WebElement> findElements(By by) {
		int retries = 0;
		
		while(retries < MAX_RETRIES) {
			try {
				return this.originalElement.findElements(by);
				
			}
			catch(StaleElementReferenceException e) {
				refreshElement();
			}
			retries++;
		}
		
		throw new StaleElementReferenceException
		(String.format("Element is still stale after % s tries", MAX_RETRIES));
	}

	@Override
	public WebElement findElement(By by) {
		int retries = 0;
		
		while(retries < MAX_RETRIES) {
			try {
				return this.originalElement.findElement(by);
				
			}
			catch(StaleElementReferenceException e) {
				refreshElement();
			}
			retries++;
		}
		
		throw new StaleElementReferenceException
		(String.format("Element is still stale after % s tries", MAX_RETRIES));
	}

	@Override
	public boolean isDisplayed() {
		int retries = 0;
		
		while(retries < MAX_RETRIES) {
			try {
				return this.originalElement.isDisplayed();
				
			}
			catch(StaleElementReferenceException e) {
				refreshElement();
			}
			retries++;
		}
		
		throw new StaleElementReferenceException
		(String.format("Element is still stale after % s tries", MAX_RETRIES));
	}

	@Override
	public Point getLocation() {
		int retries = 0;
		
		while(retries < MAX_RETRIES) {
			try {
				return this.originalElement.getLocation();
				
			}
			catch(StaleElementReferenceException e) {
				refreshElement();
			}
			retries++;
		}
		
		throw new StaleElementReferenceException
		(String.format("Element is still stale after % s tries", MAX_RETRIES));
	}

	@Override
	public Dimension getSize() {
		int retries = 0;
		
		while(retries < MAX_RETRIES) {
			try {
				return this.originalElement.getSize();
				
			}
			catch(StaleElementReferenceException e) {
				refreshElement();
			}
			retries++;
		}
		
		throw new StaleElementReferenceException
		(String.format("Element is still stale after % s tries", MAX_RETRIES));
	}

	@Override
	public Rectangle getRect() {
		int retries = 0;
		
		while(retries < MAX_RETRIES) {
			try {
				return this.originalElement.getRect();
				
			}
			catch(StaleElementReferenceException e) {
				refreshElement();
			}
			retries++;
		}
		
		throw new StaleElementReferenceException
		(String.format("Element is still stale after % s tries", MAX_RETRIES));
	}

	@Override
	public String getCssValue(String propertyName) {
		int retries = 0;
		
		while(retries < MAX_RETRIES) {
			try {
				return this.originalElement.getCssValue(propertyName);
				
			}
			catch(StaleElementReferenceException e) {
				refreshElement();
			}
			retries++;
		}
		
		throw new StaleElementReferenceException
		(String.format("Element is still stale after % s tries", MAX_RETRIES));
	}
}
