package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected static final Long DEFAULT_TIME = 20L;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(driver, Duration.ofSeconds(timeToWait)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitForAjaxToComplete(long timeToWait) {
        new WebDriverWait(driver, Duration.ofSeconds(timeToWait)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return window.jQuery != undefined && jQuery.active == 0;"));
    }

    public void waitForAjaxToCompletePdp(long timeToWait) {
        new WebDriverWait(driver, Duration.ofSeconds(timeToWait)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return window.jQuery != undefined && jQuery.active <=2;"));
    }

    public void waitVisibilityOfElement(long timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWait));
       wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitElementToBeClickable(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIME);
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public WebElement waitOfElementLocated(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIME);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public List<WebElement> waitElementOfListToBeVisible(List<WebElement> webElement) {
        WebDriverWait wait = new WebDriverWait(driver,DEFAULT_TIME);
        return wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
    }

}
