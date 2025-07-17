package merchandise.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseTest;
import Merchandise.PageComponents.CartPage;
import Merchandise.PageComponents.HomePage;

public class cartTest extends BaseTest {
	
	public WebDriver driver;
	CartPage cartPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUpPages() {
		cartPage = new CartPage(driver);
		homePage = new HomePage(driver);
	}
	
	@Test
	public void verifyIfProductDisplayedInCart() {
		
		homePage.AddProducts();
	    homePage.GotoCartPage();
		Assert.assertTrue(cartPage.isProductDisplayed("ZARA COAT 3"));
	}
	
	@Test
	public void verifyCartIsEmpty() {
		homePage.AddProducts();
		homePage.GotoCartPage();
		cartPage.DeleteItems();
		Assert.assertTrue(cartPage.isCartEmpty(),"Cart should be empty after deleting item");
	}
	
	@Test
    public void verifyCartTotalEqualsSubtotal() {
        homePage.AddProducts(); // Add product(s)
        homePage.GotoCartPage();
        Assert.assertTrue(cartPage.validateTotals(), "Total does not match Subtotal");
    }
	
	@Test
    public void verifyContinueShoppingReturnsToHomePage() {
        homePage.AddProducts();
        homePage.GotoCartPage();
        cartPage.GoToHomePage();
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard")); // Adjust this as per your site
    }

	

}
