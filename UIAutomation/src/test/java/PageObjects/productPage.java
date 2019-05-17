package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*Page Object for item/product viewing once selected, can be used with loaded page or popup quickview
 * but will reqire separate values as the quickview uses alternate iframe and some differing locators.
 */
public class productPage {

	WebDriver driver = null;
	
	//Objects and associated selector paths/locations
	//Objects from product page used for value check in cart
	By nameCheck = By.xpath("//*[@id=\"center_column\"]/div/div/div[3]/h1");
	By quantityCheck = By.xpath("//*[@id=\"quantity_wanted\"]");
	By colourCheck = By.cssSelector("span[id='layer_cart_product_attributes']");
	By colour = By.xpath("//*[@id=\"color_14\"]");
	By addToCart = By.cssSelector("button[name='Submit']");
	By close = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/span");
	By cart = By.cssSelector("a[title='View my shopping cart']");
	
	public productPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement name() {
		return driver.findElement(nameCheck);
	}
	public WebElement colourChoice() {
		return driver.findElement(colour);
	}
	public WebElement addCart() {
		return driver.findElement(addToCart);
	}
	public WebElement closewindow() {
		return driver.findElement(close);
	}
	public WebElement viewCart() {
		return driver.findElement(cart);
	}
	public WebElement quantity() {
		return driver.findElement(quantityCheck);
	}
	public WebElement colourCheck() {
		return driver.findElement(colourCheck);
	}
	
}
