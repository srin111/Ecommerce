package Merchandise.PageComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitUtils;

public class CheckOutPage {
	

	
	    WebDriver driver;

	    public CheckOutPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    // Payment method section (assumed default credit card selected)
	    @FindBy(xpath = "//input[@value='4542 9931 9292 2293']")
	    WebElement creditCardNumber;

	    @FindBy(xpath = "")
	    WebElement expiryDate;

	    @FindBy(xpath = "//div[@class='payment__cc']//div[2]//input[1]")
	    WebElement cvvCode;

	    @FindBy(xpath = "//div[@class='payment__info']//div[3]//div[1]//input[1]")
	    WebElement nameOnCard;

	    @FindBy(xpath = "//input[@name='coupon']")
	    WebElement couponCode;

	    @FindBy(xpath = "//button[@type='submit']")
	    WebElement applyCouponButton;

	    // Shipping Information
	    @FindBy(xpath = "//input[@class='input txt text-validated ng-untouched ng-pristine ng-valid']")
	    WebElement emailAddress;

	    @FindBy(css = "input[placeholder='Select Country']")
	    WebElement countryInput;
	    
        @FindBy(xpath = "//section[contains(@classs,'ta-results')]//button[contains(@class, 'ta-item')")
        List<WebElement> countrySuggestions;

	    // Place Order
	    @FindBy(xpath = "//a[@class='btnn action__submit ng-star-inserted']")
	    WebElement placeOrderButton;

	    // Product Summary
	    @FindBy(xpath = "//img[@class='iphone']")
	    WebElement productImage;

	    @FindBy(xpath = "//div[@class='item__title']")
	    WebElement productName;

	    @FindBy(xpath = "//div[@class='item__quantity']")
	    WebElement productQuantity;

	    // ---------------- Actions ----------------

	    public void enterCardDetails(String number, String expiry, String cvv, String name) {
	        creditCardNumber.sendKeys(number);
	        expiryDate.sendKeys(expiry);
	        cvvCode.sendKeys(cvv);
	        nameOnCard.sendKeys(name);
	    }

	    public void applyCoupon(String coupon) {
	        couponCode.sendKeys(coupon);
	        applyCouponButton.click();
	    }

	    public void enterShippingDetails(String email) {
	        emailAddress.sendKeys(email);
	        
	            }
	        
	    public void selectCountry(String countryName) {
	    	countryInput.sendKeys(countryName.substring(0, 3));
	    	WaitUtils.waitForAllElementsToBeVisible(driver, countrySuggestions, 5);
	    	for(WebElement suggestions: countrySuggestions ) {
	    		if(suggestions.getText().equalsIgnoreCase(countryName)) {
	    			suggestions.click();
	    			break;
	    		}
	    		
	    		
	    	}
	    	
	    }

	    public void placeOrder() {
	        placeOrderButton.click();
	    }

	    public String getProductName() {
	        return productName.getText().trim();
	    }

	    public String getProductQuantity() {
	        return productQuantity.getText().trim();
	    }

		public boolean isErrorDisplayed() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean isOrderSuccessful() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean isCountrySelected(String expectedCountry) {
		    try {
		        String selectedCountry = countryInput.getAttribute("value").trim();
		        return selectedCountry.equalsIgnoreCase(expectedCountry);
		    } catch (Exception e) {
		        return false;
		    }
		}

	}

	
	


