package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends BasePage {
    public ItemPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input [@id='add-to-cart-button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//input [@aria-labelledby='attach-sidesheet-view-cart-button-announce']")
    private WebElement confirmAddToCartButton;

    @FindBy(xpath = "//a[contains(text(),'Go to Cart')]")
    private WebElement goToCartButton;

    public void addToCart() {
        addToCartButton.click();
    }

    public void confirmAddToCart() {
        waitVisibilityOfElement(30, confirmAddToCartButton);
        confirmAddToCartButton.click();
    }

    public void goToShoppingCart() {
        goToCartButton.click();
    }


}



