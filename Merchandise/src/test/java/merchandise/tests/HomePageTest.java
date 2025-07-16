package merchandise.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Merchandise.PageComponents.HomePage;

public class HomePageTest extends BaseTest{
	
	WebDriver driver;
	HomePage HomePage = new HomePage(driver);

	@Test
	public void VerifyCartCount() {
		
		HomePage.AddProducts();
		int ItemQty = HomePage.NumberofItemsAtCart();
		Assert.assertEquals(ItemQty, 1,"Equal to number of items added");	
		
	}
	
	@Test
	public void TakeToPages() {
		HomePage.GotoCartPage();
		HomePage.GotoOrdersPage();
		
	}
	
	

}
