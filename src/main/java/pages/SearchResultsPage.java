package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
    private List<WebElement> searchResultList;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
    private List<WebElement> itemsDescriptionList;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSecondItemOnSearchResultPage() {
        searchResultList.get(1).click();
    }

    public List<String> getTextListFromItemsDescriptionList() {
        waitForPageLoadComplete(DEFAULT_TIME);
        waitElementOfListToBeVisible(itemsDescriptionList);
        return itemsDescriptionList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

}
