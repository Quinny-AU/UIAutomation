package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Page Object used for the general purpose browsing
public class shopDressBrowse {
	
	WebDriver driver = null;
	
	//Objects and associated selector paths/locations
	By sortBy = By.cssSelector("select[id='selectProductSort']");
	//Items to check first 3 gird elements for correct sort by
	By firstItem = By.cssSelector("#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.last-line.first-item-of-tablet-line.first-item-of-mobile-line.last-mobile-line > div > div.right-block > div.content_price > span.price.product-price");
	By secondItem = By.cssSelector("#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.last-line.last-item-of-tablet-line.last-mobile-line > div > div.right-block > div.content_price > span");
	By thirdItem = By.cssSelector("#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.last-in-line.last-line.first-item-of-tablet-line.last-item-of-mobile-line.last-mobile-line > div > div.right-block > div.content_price > span.price.product-price");
	//Item to be added to cart or viewed for more info
	By product = By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img");
	
	public shopDressBrowse(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement selectSort() {
		return driver.findElement(sortBy);
	}
	public WebElement firstDress() {
		return driver.findElement(firstItem);
	}
	public WebElement secondDress() {
		return driver.findElement(secondItem);
	}
	public WebElement thirdDress() {
		return driver.findElement(thirdItem);
	}
	public WebElement product() {
		return driver.findElement(product);
	}
	
	
}
