package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input [@id='ap_email']")
    private WebElement inputEmailField;

    @FindBy(xpath = "//input [@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//input [@type='password']")
    private WebElement inputPasswordField;

    @FindBy(xpath = "//input [@id='signInSubmit']")
    private WebElement signInButton;

    @FindBy(xpath = "//h4 [contains(text(),'There was a problem')]")
    private WebElement warningImagine;



    public void sendEmailInInputEmailField (String email){
        waitVisibilityOfElement(30,inputEmailField);
        inputEmailField.sendKeys(email);
    }

    public void clickOnContinueButton () {
        continueButton.click();
    }

    public void sendPasswordInInputPasswordField (String password){
        waitVisibilityOfElement(30,inputPasswordField);
        inputPasswordField.sendKeys(password);
    }
    public void clickOnSignButton () {
        signInButton.click();
    }

    public boolean isWarningMessageDisplayed() {
       return warningImagine.isDisplayed();
    }
}

