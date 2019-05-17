package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Page Object for login/registration page
public class accountAccess {
	
	WebDriver driver = null;
	
	//Objects and associated selector paths/locations
	By emailReg = By.cssSelector("input[name='email_create']");
	By email = By.cssSelector("input[name='email']");
	By password = By.cssSelector("input[name='passwd']");
	By create = By.cssSelector("button[id='SubmitCreate']");
	By login = By.cssSelector("button[name='SubmitLogin']");
	By dresses = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
	
	public accountAccess(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement registerEmail() {
		return driver.findElement(emailReg);
	}
	public WebElement email() {
		return driver.findElement(email);
	}
	public WebElement password() {
		return driver.findElement(password);
	}
	public WebElement createSubmit() {
		return driver.findElement(create);
	}
	public WebElement submitLogin() {
		return driver.findElement(login);
	}
	public WebElement dressesMenu() {
		return driver.findElement(dresses);
	}
	
}
