package Merchandise.PageComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

		
	}
	
	
	@FindBy (xpath = "//button[normalize-space()='Continue Shopping']")
	WebElement continueShopping;
	
	@FindBy(xpath = "//button[normalize-space()='Checkout']")
	WebElement checkOut;
	
	@FindBy(xpath ="//button[normalize-space()='Buy Now']")
	WebElement buyNow;
	
	@FindBy(xpath = "//i[@class='fa fa-trash-o']")
	WebElement deleteIcon;
	
	@FindBy(xpath="//span[normalize-space()='Subtotal']")
	WebElement subTotal;
	
	@FindBy(xpath ="//span[normalize-space()='Total']")
	WebElement total;
	
	@FindBy(xpath = "//h3[normalize-space()='ZARA COAT 3']")
	WebElement productName;
	
	@FindBy(xpath = "//h1[normalize-space()='No Products in Your Cart !']")
	WebElement emptyCartMessage;
	
	public void clickBuyNow() {
		buyNow.click();
		
	}
	
	public void clickCheckOut() {
		checkOut.click();
	}
	
	public void DeleteItems() {
		deleteIcon.click();
	}
	
	public void GoToHomePage() {
		continueShopping.click();
	}
	
	public boolean isProductDisplayed(String ExpectedName) {
		return productName.getText().trim().equalsIgnoreCase(ExpectedName);
		
	}
	
	public boolean isCartEmpty() {
		return emptyCartMessage.isDisplayed();
		
	}
	
	public String getSubTotal() {
		return subTotal.getText().trim();
	}
	
	public String getTotal() {
		return total.getText().trim();
	}
	
	public double parseAmount(String text) {
	    return Double.parseDouble(text.replaceAll("[^\\d.]", ""));
	}
	public boolean validateTotals() {
	    double totalValue = parseAmount(getTotal());
	    double subTotalValue = parseAmount(getSubTotal());
	    return totalValue == subTotalValue;
	}

}
