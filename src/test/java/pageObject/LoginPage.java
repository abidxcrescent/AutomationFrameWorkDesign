package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import library.Configuration;

public class LoginPage {
	
	public WebDriver driver;
	
	
	
	public LoginPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}


	@FindBy (id = "Email")
	@CacheLookup
	public WebElement email;
	
	@FindBy (id = "Password")
	@CacheLookup
	public WebElement password;
	
	@FindBy (xpath = "/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	@CacheLookup
	public WebElement submit;
	
	
	public void setUserName(){
		email.clear();
		email.sendKeys(Configuration.getUserName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void setPassword(){
		password.clear();
		password.sendKeys(Configuration.getPassword());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickSubmit() {
		submit.click();
	}
}
