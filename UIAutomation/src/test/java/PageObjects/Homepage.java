package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Page Object for the default loaded homepage
public class Homepage {
	
	WebDriver driver = null;
	
	//Objects and associated selector paths/locations
	By Signin = By.cssSelector("a[class='login']");
	By dresses = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement SigninButton() {
		return driver.findElement(Signin);
	}
	public WebElement dressesMenu() {
		return driver.findElement(dresses);
	}
}
