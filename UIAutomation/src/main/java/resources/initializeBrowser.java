package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class initializeBrowser {

	public Properties prop = new Properties();
	FileInputStream fs;
	
	public WebDriver initialize() throws IOException {
		
		WebDriver driver = null;
		
		//Method defined below that is used to generate and link the properites file containing test data
		setPropertyFile();
		//Loads properties form targeted link/location
		prop.load(fs);
		
		//Grabs the inputted value of browser from command line
		String browserName = System.getProperty("browser");
		
		/*Distinguishes which browser has bene request and then creates WebDriver of set type, 
		either Chrome or Gecko(FireFox)
		Can add more else if statements for inclusion of other WebDriver types
		*/
		if(browserName.equals("chrome")) {
			//Sets path for the WebDriver
			System.setProperty("webdriver.chrome.driver","C:\\Users\\777632\\webdriver\\chromedriver_win32_71_73\\chromedriver.exe");
			driver = new ChromeDriver();
			//Increases window size to full screen upon browser launch
			driver.manage().window().maximize();
			//Loads URL stored in test data file
			driver.get(prop.getProperty("url"));
		}
		else if(browserName.equals("firefox")) {
			//Sets path for the WebDriver
			System.setProperty("webdriver.gecko.driver","C:\\Users\\777632\\webdriver\\Firefox\\geckodriver.exe");
			driver = new FirefoxDriver();
			//Increases window size to full screen upon browser launch
			driver.manage().window().maximize();
			//Loads URL stored in test data file
			driver.get(prop.getProperty("url"));
		}
		//Returns the initialized type of driver and launches browser
		return driver;
	}
	
	//Overloaded method for loading browser to a specific URL that operates orignally away from homepage
	public WebDriver initialize(String url) throws IOException {
		
		WebDriver driver = null;
		
		setPropertyFile();
		
		prop.load(fs);
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\777632\\webdriver\\chromedriver_win32_71_73\\chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.get(url);
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\777632\\webdriver\\Firefox\\geckodriver.exe");
			driver = new FirefoxDriver();
			
			driver.manage().window().maximize();
			driver.get(url);
		}
		
		return driver;
	}
	//Method used to link the test data stored in a properties file and loads the test data
	//Used both within the above code and also in the main step definitions file
	public void setPropertyFile() throws IOException {
		fs = new FileInputStream("C:\\Users\\777632\\eclipse-workspace\\UIAutomation\\src\\main\\java\\resources\\data.properties");
		prop.load(fs);
	}
}
