package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//input[@value='Delete']")
    private WebElement deleteFromCartButton;

    @FindBy (xpath = "//span [@class='a-button-text a-declarative']")
    private WebElement changeQuantityButton;

    @FindBy(xpath = "//a [@data-value='{\"stringVal\":\"2\"}']")
    private WebElement changeQuantityTo2button;

    public void clickOnDeleteFromCartButton () {
        waitVisibilityOfElement(30,deleteFromCartButton);
        deleteFromCartButton.click();
    }

    public void changeNumberOFItemsInTheCart(){
        changeQuantityButton.click();
        waitVisibilityOfElement(10,changeQuantityTo2button);
        changeQuantityTo2button.click();
    }

}
