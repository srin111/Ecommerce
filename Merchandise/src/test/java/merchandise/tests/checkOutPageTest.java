package merchandise.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseTest;
import Merchandise.PageComponents.CartPage;
import Merchandise.PageComponents.CheckOutPage;
import Merchandise.PageComponents.HomePage;
import Base.Data;






public class checkOutPageTest extends BaseTest {

    public WebDriver driver;
    CheckOutPage checkoutPage;
    CartPage cartPage;
    HomePage homePage;

    @BeforeMethod
    public void setUpPages() {
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckOutPage(driver);
    }
    @Test(dataProvider = "JsonCardDetails" ,dataProviderClass = Data.class)
    public void testEnterPaymentAndShippingDetailsAndPlaceOrder(String number,String expiry,String cvv,String name) {
        // Add product and navigate to Checkout
        homePage.AddProducts();
        homePage.GotoCartPage();
        cartPage.clickBuyNow(); // OR cartPage.clickCheckOut(); based on your flow

        // Fill in payment information
        checkoutPage.enterCardDetails(number, expiry, cvv, name);;

        // Optional: Apply coupon
        checkoutPage.applyCoupon("DISCOUNT10");
        

        // Fill in shipping info
        checkoutPage.enterShippingDetails("testuser@example.com");
        checkoutPage.selectCountry("India");

        // Place the order
        checkoutPage.placeOrder();

        // Validate success message or landing page (modify as per your site)
        Assert.assertTrue(checkoutPage.isOrderSuccessful(), "Order placement failed.");
    }

    @Test(dataProvider="CardDetails" , dataProviderClass = Data.class)
    public void testInvalidCardDetails(String number, String expiry, String cvv, String name, String email, String country, String coupon) {

        homePage.AddProducts();
        homePage.GotoCartPage();
        cartPage.clickBuyNow();
     
        checkoutPage.enterCardDetails(number,expiry,cvv,name);
       

        checkoutPage.enterShippingDetails("test@example.com");
        checkoutPage.selectCountry("India");

        checkoutPage.placeOrder();

        Assert.assertTrue(checkoutPage.isErrorDisplayed(), "Expected error not displayed for invalid card.");
    }

    @Test
    public void testCountryAutoSuggestDropdown() {
        homePage.AddProducts();
        homePage.GotoCartPage();
        cartPage.clickBuyNow();

        checkoutPage.selectCountry("India");
    
        Assert.assertTrue(checkoutPage.isCountrySelected("United States"), "Auto-suggest failed for country.");
    }
}

