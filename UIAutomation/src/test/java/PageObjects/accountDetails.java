package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Page Object for entering personal details upon registration acception
public class accountDetails {

	WebDriver driver = null;
	
	//Objects and associated path locations
	//Gender choice between male and female, 1 = Male, 2 = Female, just change final digit to switch
	By gender = By.xpath("//*[@id=\"id_gender1\"]");
	//Customer personal details
	By firstName = By.cssSelector("input[id='customer_firstname']");
	By lastName = By.cssSelector("input[name='customer_lastname']");
	By password = By.cssSelector("input[id='passwd']");
	By DOBDays = By.cssSelector("select[id='days']");
	By DOBMonths = By.cssSelector("select[id='months']");
	By DOBYears = By.cssSelector("select[id='years']");
	//Address details
	By addressFirstName = By.cssSelector("input[name='firstname']");
	By addressLastName = By.cssSelector("input[name='lastname']");
	By company = By.cssSelector("input[name='company']");
	By address1 = By.cssSelector("input[name='address1']");
	By address2 = By.cssSelector("input[name='address2']");
	By city = By.cssSelector("input[name='city']");
	By state = By.cssSelector("select[name='id_state']");
	By postcode = By.cssSelector("input[name='postcode']");
	By country = By.cssSelector("select[name='id_country']");
	By other = By.cssSelector("textarea[name='other']");
	By homephone = By.cssSelector("input[name='phone']");
	By mobilephone = By.cssSelector("input[name='phone_mobile']");
	//Address alias for delivery
	By addressAlias = By.cssSelector("input[name='alias']");
	By submitAccount = By.cssSelector("button[name='submitAccount']");
	
	//Navigation
	By dresses = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
	
	public accountDetails(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement Gender() {
		return driver.findElement(gender);
	}
	public WebElement firstName() {
		return driver.findElement(firstName);
	}
	public WebElement lastName() {
		return driver.findElement(lastName);
	}
	public WebElement password() {
		return driver.findElement(password);
	}
	public WebElement DOBdays() {
		return driver.findElement(DOBDays);
	}
	public WebElement DOBmonths() {
		return driver.findElement(DOBMonths);
	}
	public WebElement DOByears() {
		return driver.findElement(DOBYears);
	}
	public WebElement addressFirstN() {
		return driver.findElement(addressFirstName);
	}
	public WebElement addressLastN() {
		return driver.findElement(addressLastName);
	}
	public WebElement company() {
		return driver.findElement(company);
	}
	public WebElement addressLine1() {
		return driver.findElement(address1);
	}
	public WebElement addressLine2() {
		return driver.findElement(address2);
	}
	public WebElement city() {
		return driver.findElement(city);
	}
	public WebElement state() {
		return driver.findElement(state);
	}
	public WebElement postCode() {
		return driver.findElement(postcode);
	}
	public WebElement country() {
		return driver.findElement(country);
	}
	public WebElement other() {
		return driver.findElement(other);
	}
	public WebElement homePhone() {
		return driver.findElement(homephone);
	}
	public WebElement mobilePhone() {
		return driver.findElement(mobilephone);
	}
	public WebElement addressAlias() {
		return driver.findElement(addressAlias);
	}
	public WebElement accountSubmit() {
		return driver.findElement(submitAccount);
	}
	public WebElement dressesMenu() {
		return driver.findElement(dresses);
	}
}
