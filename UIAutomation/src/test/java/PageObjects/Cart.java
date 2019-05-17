package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Page Object for viewing the cart summary
public class Cart {
	
	WebDriver driver = null;
	
	//Objects and associated selector paths/locations
	//The product id changes for each different product so below xpath only works for particular item and user
	By itemName = By.xpath("//*[@id=\"product_5_20_0_171429\"]/td[2]/p/a");
	By itemQuantity = By.xpath("//*[@id=\"product_5_20_0_171429\"]/td[5]/input[2]");
	By itemColour = By.xpath("//*[@id=\"product_5_20_0_171429\"]/td[2]/small[2]");
	
	public Cart(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement cartItemName() {
		return driver.findElement(itemName);
	}
	public WebElement cartItemQuantity() {
		return driver.findElement(itemQuantity);
	}
	public WebElement cartItemColour() {
		return driver.findElement(itemColour);
	}
}
