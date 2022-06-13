package pages;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class CategoriesPage extends BasePage {

    public CategoriesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Amazon.com']")
    private WebElement amazonComSellerButton;


    @FindBy(xpath = "//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']")
    private List<WebElement> listOfItemsDescription;

    @FindBy(xpath = "//span[@class='a-button-inner']//span[@class='a-button-text a-declarative']")
    private WebElement sortByButton;

    @FindBy(xpath = "//a[@id='s-result-sort-select_1']")
    private WebElement sortByPriceLowToHighButton;

    @FindBy(xpath = "//span[@class='a-price-whole']")
    private List<WebElement> listOfItemsPrice;

    @FindBy(xpath = "//a[@id='s-result-sort-select_2']")
    private WebElement sortByPriceHighToLowButton;

    public void clickBrandNameButton(final String brandName) {
        String xpath = String.format("//span[text()='%s']", brandName);
        waitOfElementLocated(By.xpath(xpath)).click();
    }

    public List<WebElement> getListOfItemsDescription() {
        return waitElementOfListToBeVisible(listOfItemsDescription);
    }
    public void clickAmazonComSellerButton() {
        waitForPageLoadComplete(DEFAULT_TIME);
        waitElementToBeClickable(amazonComSellerButton).click();
    }

    public void clickSortByButton() {
        waitElementToBeClickable(sortByButton).click();
    }

    public List<Integer> getListOfItemsPrice() {
        waitElementOfListToBeVisible(listOfItemsPrice);
        return listOfItemsPrice.stream().map(WebElement::getText).map(text -> {
            if (text.contains(",")) {
                text = text.replace(",", "");
            }
            return Integer.parseInt(text);
        }).collect(Collectors.toList());
    }

    public void clickSortByPriceHighToLowButton() {
        waitElementToBeClickable(sortByPriceHighToLowButton).click();
    }

}
