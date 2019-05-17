package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.Cart;
import PageObjects.Homepage;
import PageObjects.accountDetails;
import PageObjects.megaMenu;
import PageObjects.productPage;
import PageObjects.shopDressBrowse;
import PageObjects.accountAccess;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import resources.initializeBrowser;

//Main class which is used to run the Cucumber BDD scenarios
public class stepDefinitions extends initializeBrowser{
	
	WebDriver driver = null;
	
	//Scenario: User successfully register account
	@Given("^Initialize browser to shopping site$")
    public void initialize_browser_to_shopping_site() throws Throwable {
		/*
		 Driver and property file setup
		 Initializes browser and launches URL form property file 
		 Also class contains separate method to initialize property file for scenarios
		 where browser initialization is not needed
		 Also contains alternate method to initialize to non-homepage url
		 */
		driver = initialize();
				
		Homepage home = new Homepage(driver);
		home.SigninButton().click();
		Thread.sleep(2000);
    }
	
	//Scenario: User register account fail
	@Given("^Initialize browser to shopping site and navigates to registration$")
    public void initialize_browser_to_shopping_site_and_navigates_to_registration() throws Throwable {
		
		driver = initialize();
		Homepage home = new Homepage(driver);
		home.SigninButton().click();
		Thread.sleep(3000);
    }
	
	//Scenario: User navigates to item
	@Given("^User has logged into account with (.+) and (.+)$")
    public void user_has_logged_into_account_with_and(String email, String password) throws Throwable {
		driver = initialize();
				
		Homepage home = new Homepage(driver);
		home.SigninButton().click();
		Thread.sleep(2000);
		
		accountAccess accountLogin = new accountAccess(driver);
		accountLogin.email().sendKeys(email);
		accountLogin.password().sendKeys(password);
		Thread.sleep(1000);
		accountLogin.submitLogin().click();
		Thread.sleep(3000);
    }
	
	//Scenario: User selects item and desired colour and then adds item to cart
	@Given("^User has logged in with (.+) and (.+) and navigated to summer dresses$")
    public void user_has_logged_in_with_and_and_navigated_to_summer_dresses(String email, String password) throws Throwable {
    	/*
    	 Uses an overloaded method to setup browser to an alternate url
    	 that does not direct homepage
    	 */
    	//driver = initialize("http://automationpractice.com/index.php?id_category=11&controller=category");driver = initialize();
		
		driver = initialize();
		
		Homepage home = new Homepage(driver);
		home.SigninButton().click();
		Thread.sleep(2000);
		
		accountAccess accountLogin = new accountAccess(driver);
		accountLogin.email().sendKeys(email);
		accountLogin.password().sendKeys(password);
		Thread.sleep(1000);
		accountLogin.submitLogin().click();
		Thread.sleep(3000);
		
		megaMenu search = new megaMenu(driver);
		
		Actions action = new Actions(driver);
		action.moveToElement(search.dressesMenu());
		//Click and hold needed to work around firefox bug for element interacting
		action.clickAndHold().build().perform();
        Thread.sleep(2000);
        search.summerDresses().click();
    }
    
    //Scenario: User successfully register account
    @When("^User enters valid email address and account details$")
    public void user_enters_valid_email_address_and_account_details() throws Throwable {
		//Object for user to navigate to account creation
		accountAccess newAccount = new accountAccess(driver);
		newAccount.registerEmail().sendKeys(prop.getProperty("email"));
		Thread.sleep(2000);
		newAccount.createSubmit().click();
		//Thread.sleep(5000);
		//Needed due to slow loading and processing times to wait for element to load and become visible
		accountDetails details = new accountDetails(driver);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id_gender1\"]")));
		//Object to enter account details
		
		details.Gender().click();
		details.firstName().sendKeys(prop.getProperty("firstName"));
		details.lastName().sendKeys(prop.getProperty("lastName"));
		details.password().sendKeys(prop.getProperty("password"));
		
		Select day = new Select(details.DOBdays());
		day.selectByValue(prop.getProperty("DOBday"));
		
		Select month = new Select(details.DOBmonths());
		month.selectByValue(prop.getProperty("DOBmonth"));
		
		Select year = new Select(details.DOByears());
		year.selectByValue(prop.getProperty("DOByear"));
		details.addressFirstN().clear();
		details.addressLastN().clear();
		details.addressFirstN().sendKeys(prop.getProperty("addressFirstName"));
		details.addressLastN().sendKeys(prop.getProperty("addressLastName"));
		details.company().sendKeys(prop.getProperty("company"));
		details.addressLine1().sendKeys(prop.getProperty("addressLine1"));
		details.addressLine2().sendKeys(prop.getProperty("addressLine2"));
		details.city().sendKeys(prop.getProperty("city"));
		
		Select state = new Select(details.state());
		state.selectByValue(prop.getProperty("state"));
		
		details.postCode().sendKeys(prop.getProperty("postCode"));
		
		Select country = new Select(details.country());
		country.selectByValue(prop.getProperty("country"));
		
		details.other().sendKeys(prop.getProperty("other"));
		
		details.homePhone().sendKeys(prop.getProperty("homePhone"));
		details.mobilePhone().sendKeys(prop.getProperty("mobilePhone"));
		details.addressAlias().clear();
		details.addressAlias().sendKeys(prop.getProperty("alias"));
    }
	
	//Scenario: User register account fail
	@When("^User enters invalid (.+) address$")
    public void user_enters_invalid_address(String email) throws Throwable {
		accountAccess newAccount = new accountAccess(driver);
		newAccount.registerEmail().sendKeys(email);
		Thread.sleep(2000);
		newAccount.createSubmit().click();
		Thread.sleep(3000);
    }
	
	//Scenario: User navigates to item
	@When("^User searches for summer dress via megamenu$")
    public void user_searches_for_summer_dress_via_megamenu() throws Throwable {
        megaMenu search = new megaMenu(driver);
		
		Actions action = new Actions(driver);
		action.moveToElement(search.dressesMenu());
		//Click and hold needed to work around firefox bug for element interacting
		action.clickAndHold().build().perform();
        Thread.sleep(2000);
        search.summerDresses().click();
		
        /*Below can be used to distinguish between different browser instances
        if(driver instanceof ChromeDriver || driver instanceof FirefoxDriver) {
		}
		else if(driver instanceof FirefoxDriver) {
		}*/
    }
	
	//Scenario: User selects item and desired colour and then adds item to cart
    @When("^User clicks on dress, selects colour and adds item to cart$")
    public void user_clicks_on_dress_selects_colour_and_adds_item_to_cart() throws Throwable {
    	Thread.sleep(3000);
    	shopDressBrowse item = new shopDressBrowse(driver);
    	//Executes javascript locator as firefox has a bug where element is not visible or cannot be scrolled to
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", item.product());
        //item.product().click();
        
        Thread.sleep(7000);
        
        //driver.switchTo().frame(driver.findElement(By.className("fancybox-iframe")));
        
        productPage product = new productPage(driver);
        product.colourChoice().click();
        
        Thread.sleep(2000);
        
        product.addCart().click();
        
        Thread.sleep(1000);
        
    }
    
    //Scenario: User successfully register account
    @Then("^User successfully registers account$")
    public void user_successfully_registers_account() throws Throwable {
        accountDetails account = new accountDetails(driver);
        account.accountSubmit().click();
        Thread.sleep(2000);
        //Check if account registered and has been directed to account page
        String urlCheck = driver.getCurrentUrl();
        String accountURL = "http://automationpractice.com/index.php?controller=my-account";
        Assert.assertEquals(urlCheck, accountURL);
        driver.quit();
        Thread.sleep(3000);
        //Account should be successfully registered
    }
    
    //Scenario: User register account fail
    @Then("^User account registration fails$")
    public void user_account_registration_fails() throws Throwable {
    	//Checks current url as page should be the same
    	String urlCheck = driver.getCurrentUrl();
        String pageURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        Assert.assertEquals(urlCheck, pageURL);
        Thread.sleep(1000);
        //Check if error message has showed up
        Assert.assertEquals(driver.findElement(By.id("create_account_error")).isEnabled(), true);
        Thread.sleep(2000);
    	
    }
    
    //Scenario: User register account fail
    @Then("^User registration is rejected$")
    public void user_registration_is_rejected() throws Throwable {
        //Account registration is rejected as email already in use
    	//Checks current url as page should be the same
    	String urlCheck = driver.getCurrentUrl();
        String pageURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        Assert.assertEquals(urlCheck, pageURL);
        Thread.sleep(1000);
        //Check if error message has showed up
        Assert.assertEquals(driver.findElement(By.id("create_account_error")).isEnabled(), true);
        Thread.sleep(2000);
        driver.quit();
    }
    
    //Scenario: User navigates to item
    @Then("^Product grid should display summer dresses by increasing price$")
    public void product_grid_should_display_summer_dresses_by_increasing_price() throws Throwable {
        shopDressBrowse dress = new shopDressBrowse(driver);
        //Scroll into view of dresses
        JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", dress.product());
        
    	Thread.sleep(2000);
    	
        Double price1 = Double.parseDouble(dress.firstDress().getText().replace("$", ""));
        Double price2 = Double.parseDouble(dress.secondDress().getText().replace("$", ""));
        Double price3 = Double.parseDouble(dress.thirdDress().getText().replace("$", ""));
       
        /*Below is to check whether the sort by is working,
        in current testing does not work hence why this test should fail and will
        Requires review into how to properly handle this failing process
        */
        try {
        	Assert.assertTrue(price1<price2);
        }
        catch(AssertionError e) {
        	driver.quit();
        	throw new AssertionError("Sort by price is not sorting results correctly/at all. Outcome: ", e);
        }
        
       try {
        	Assert.assertTrue(price2<price3);
        }
        catch(AssertionError e) {
        	driver.quit();
        	throw new AssertionError("Sort by price is not sorting results correctly/at all. Outcome: ", e);
        }
        //Uncomment below and comment try catch statement for the program to build
        //Assert.assertFalse(price2<price3);
        
        Thread.sleep(3000);
        driver.quit();
    }
    
    //Scenario: User selects item and desired colour and then adds item to cart
    @Then("^Validate that correct item added and information in cart is correct$")
    public void validate_that_correct_item_added_and_information_in_cart_is_correct() throws Throwable {
    	productPage product = new productPage(driver);
        
    	//driver.switchTo().defaultContent();
    	//Used to ensure popup menu has time to load otherwise throws exeception
    	Thread.sleep(2000);
    	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    	
    	product.closewindow().click();
    	
    	String itemName = product.name().getText();
    	
    	Integer quantity = Integer.parseInt(product.quantity().getAttribute("value"));
    	
    	String colour = product.colourChoice().getAttribute("name");
    	
    	Thread.sleep(1000);
    	
    	product.viewCart().click();
    	
    	Thread.sleep(1000);
    	
    	Cart cart = new Cart(driver);
    	
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", cart.cartItemName());
    	
    	Thread.sleep(2000);
    	
    	String cartItemName = cart.cartItemName().getText();
    	
    	Assert.assertEquals(itemName, cartItemName);
    	
    	Integer cartQuantity = Integer.parseInt(cart.cartItemQuantity().getAttribute("value"));
    	
    	Assert.assertEquals(quantity, cartQuantity);
    	
    	String cartItemColour = cart.cartItemColour().getText();
    	
    	//Alternative method could be to split both strings into individual elements to get perfect match
    	
    	Assert.assertTrue(cartItemColour.contains(colour));
    	
    	Thread.sleep(2000);
    	
    	driver.quit();
    }
    
    //Scenario: User register account fail
    @And("^User enters already registered (.+)$")
    public void user_enters_already_registered(String registeredEmail) throws Throwable {
    	accountAccess newAccount = new accountAccess(driver);
    	newAccount.registerEmail().clear();
		newAccount.registerEmail().sendKeys(registeredEmail);
		Thread.sleep(2000);
		newAccount.createSubmit().click();
		Thread.sleep(3000);
    }
    
    //Scenario: User navigates to item
    @And("^User sorts results by price$")
    public void user_sorts_results_by_price() throws Throwable {
        shopDressBrowse dress = new shopDressBrowse(driver);
        Select sort = new Select(dress.selectSort());
        sort.selectByValue("price:asc");
        Thread.sleep(5000);
    }
}
