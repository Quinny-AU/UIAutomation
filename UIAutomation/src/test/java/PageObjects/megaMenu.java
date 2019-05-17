package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Page Object for the Mega-Menu which is used site-wide for navigation
public class megaMenu {

	WebDriver driver = null;
	
	//Objects and associated selector paths/locations
	By dresses = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
	By summerDresses = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a");
	
	public megaMenu(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement dressesMenu() {
		return driver.findElement(dresses);
	}
	public WebElement summerDresses() {
		return driver.findElement(summerDresses);
	}
}
