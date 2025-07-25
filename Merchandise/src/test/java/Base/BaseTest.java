package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Utilities.WaitUtils;

public class BaseTest {


	    public WebDriver driver;
	    public WaitUtils wait;

	    @BeforeMethod
	    public void setup() {
	        // Optional: Set system property if needed
	        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://rahulshettyacademy.com/client/#/dashboard/dash"); // Replace with actual URL
	        new WaitUtils(driver);
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
	
