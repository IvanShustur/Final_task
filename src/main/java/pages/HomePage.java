package pages;

import io.cucumber.java.en.And;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//span [@id='nav-link-accountList-nav-line-1']")
    private WebElement signInButton;

    @FindBy(xpath = "//span [@class='hm-icon-label']")
    private WebElement openMenuButton;

    @FindBy(css = ".nav-cart-count")
    private WebElement cartButton;

    @FindBy(xpath = "//input [@aria-label='Search']")
    private WebElement inputSearchRequestField;

    @FindBy(xpath = "//input [@id='nav-search-submit-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[text()='Electronics']")
    private WebElement electronicsButton;

    @FindBy(xpath = "//div[@cel_widget_id='Navigation-desktop-HamburgerMenu']//a[text()='Headphones']")
    private WebElement headphonesButton;



    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void isSignInButtonVisible() {
        signInButton.isDisplayed();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public String verifyLoggedIn () {
        return signInButton.getText();
    }

    public void sendRequestInInputSearchField (String request) {
        inputSearchRequestField.sendKeys(request);
    }
    public void clickOnSearchButton (){
        searchButton.click();
    }

    public String getAmountOfProductInTheCart() {
        waitVisibilityOfElement(30, cartButton);
        return cartButton.getText();
    }
    public void clickOnCartButton() {
        cartButton.click();
    }

    public void enterTextToSearchField(String searchText) {
        waitForPageLoadComplete(DEFAULT_TIME);
        inputSearchRequestField.clear();
        inputSearchRequestField.sendKeys(searchText, Keys.ENTER);
    }

    public void clickOpenMenuButton() {
        waitForPageLoadComplete(DEFAULT_TIME);
        openMenuButton.click();
    }
    public void clickElectronicsButton() {
        waitElementToBeClickable(electronicsButton).click();
    }

    public void clickHeadphonesButton() {
        waitElementToBeClickable(headphonesButton).click();
    }
}


