package Merchandise.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	 WebDriver driver;
	 
	 
	 public HomePage(WebDriver driver) {
		 
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
		 
	 }
	 
	 @FindBy(css =".btn.w-10.rounded")
	 WebElement AddtoCart1;
	 
	 @FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
	 WebElement ordersButton;

	 @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	 WebElement cartButton;
	 
	 By cartCountLabel = By.xpath("//button[@routerlink='/dashboard/cart']/label");


	 
	 public void AddProducts() {
		 AddtoCart1.click();
	 }
	 
	 public void GotoOrdersPage() {
		 ordersButton.click();
	 }
	 
	 public void GotoCartPage() {
		 cartButton.click();
	 }
	 
	 public int NumberofItemsAtCart() {
		 String cartText = driver.findElement(cartCountLabel).getText().trim();
	        return Integer.parseInt(cartText);
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	

}
