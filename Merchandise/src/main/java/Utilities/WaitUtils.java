package Utilities;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class WaitUtils {

    // Wait until the element is visible (By locator)
    public static WebElement waitForVisible(WebDriver driver, By locator, long timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait until the element is visible (WebElement)
    public static void waitForVisible(WebDriver driver, WebElement element, long timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait until the element is clickable (By locator)
    public static WebElement waitForClickable(WebDriver driver, By locator, long timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Wait until the element is clickable (WebElement)
    public static WebElement waitForClickable(WebDriver driver, WebElement element, long timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Wait until the element is present in the DOM (may not be visible)
    public static WebElement waitForPresence(WebDriver driver, By locator, long timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Wait until the element is invisible (By locator)
    public static void waitForInvisible(WebDriver driver, By locator, long timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    // Wait until the element is invisible (WebElement)
    public static void waitForInvisible(WebDriver driver, WebElement element, long timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    // Wait until all elements are visible (used for lists)
    public static void waitForAllElementsToBeVisible(WebDriver driver, List<WebElement> elements, long timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    // Wait until the current URL contains the expected substring
    public static void waitForURLContains(WebDriver driver, String partialURL, long timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.urlContains(partialURL));
    }

    // Wait until the page title is exactly the expected string
    public static void waitForTitleIs(WebDriver driver, String expectedTitle, long timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.titleIs(expectedTitle));
    }
}

