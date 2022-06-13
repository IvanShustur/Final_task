package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;
import org.assertj.core.api.SoftAssertions;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DefinitionSteps {
    private static final long DEFAULT_TIMEOUT = 60;

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    SearchResultsPage searchResultsPage;
    ItemPage itemPage;
    ShoppingCartPage shoppingCartPage;
    private CategoriesPage categoriesPage;
    BasePage basePage;

    PageFactoryManager pageFactoryManager;

    @Given("user navigates to home page")
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
        driver.get("https://www.amazon.com/");
    }

    @And("user goes to login page")
    public void goToLoginPage() {
        pageFactoryManager.getHomePage().clickSignInButton();
    }

    @And("user logs in {string},{string}")
    public void signIn(String email, String password) {
        homePage = pageFactoryManager.getHomePage();
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.sendEmailInInputEmailField(email);
        loginPage.clickOnContinueButton();
        loginPage.sendPasswordInInputPasswordField(password);
        loginPage.clickOnSignButton();
    }

    @Then("user verify is he logged in {string}")
    public void userVerifyIsHeLoggedIn(final String expectedText) {
        assertEquals(homePage.verifyLoggedIn(), expectedText);
    }

    @And("user search  product {string}")
    public void userSearchSomeProduct(String request) {
        homePage.sendRequestInInputSearchField(request);
        homePage.clickOnSearchButton();
    }
    @When("user chooses second item on the search result page")
    public void openSecondItemFromTheSearchResultPage(){
        searchResultsPage = pageFactoryManager.getSearchResultPage();
        searchResultsPage.clickOnSecondItemOnSearchResultPage();
    }
    @And("user adds item to cart")
    public void clickOnAddToCartButton(){
        itemPage = pageFactoryManager.getItemPage();
        itemPage.addToCart();
        itemPage.confirmAddToCart();

    }
    @Then("user checks that cart contain {string} product")
    public void checkAmountOfProductsInTheCart(String expected){
        assertEquals(homePage.getAmountOfProductInTheCart(),expected);
    }

    @And("user deletes item from cart")
    public void clickOnDeleteFromCartButton(){
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.clickOnDeleteFromCartButton();
    }

    @And("user opens shopping cart")
    public void openShoppingCart() {
        homePage = pageFactoryManager.getHomePage();
        homePage.clickOnCartButton();
    }
    @And("user passes to shopping cart")
     public void goToShopping() {
        itemPage.goToShoppingCart();
    }

    @And("user input incorrect {string}")
    public void userInputIncorrectEmail(String email) {
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.sendEmailInInputEmailField(email);
        loginPage.clickOnContinueButton();
    }

    @Then("user checks the warning of incorrect email input")
    public void userSeesTheWarningOfIncorrectEmailInput() {
        assertTrue(loginPage.isWarningMessageDisplayed());

    }

    @And("user input correct {string} and incorrect {string}")
    public void userInputCorrectEmailAndIncorrectPassword(String email, String password) {
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.sendEmailInInputEmailField(email);
        loginPage.clickOnContinueButton();
        loginPage.sendPasswordInInputPasswordField(password);
        loginPage.clickOnSignButton();
    }

    @And("user change number of items in the cart")
    public void userChangeNumberOfItemsInTheCart() {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.changeNumberOFItemsInTheCart();
    }

    @And("User opens menu")
    public void clickOpenMenuButton() {
       homePage = pageFactoryManager.getHomePage();
        homePage.clickOpenMenuButton();
    }

    @And("User clicks 'Electronics' button")
    public void clickElectronicsButton() {
        homePage.clickElectronicsButton();
    }

    @When("User chooses filtering by {string}")
    public void userChoosesFilteringByBrandName(final String brandName) {
        categoriesPage = pageFactoryManager.getCategoriesPage();
        categoriesPage.clickBrandNameButton(brandName);
    }

    @And("User clicks 'Headphones' button")
    public void userClicksHeadphonesButton() {
        homePage = pageFactoryManager.getHomePage();
        homePage.clickHeadphonesButton();
    }


    @Then("User checks that results contain {string}")
    public void userChecksThatResultsContainBrandName(final String brandName) {
        SoftAssertions softAssert = new SoftAssertions();
        categoriesPage.getListOfItemsDescription()
                .forEach(webElement -> softAssert
                        .assertThat(webElement.getText().contains(brandName)));
        softAssert.assertAll();
    }

    @And("User chose amazon.com seller")
    public void userChoseAmazonComSellerButton() {
        categoriesPage = pageFactoryManager.getCategoriesPage();
        categoriesPage.clickAmazonComSellerButton();
    }

    @When("User sorts items by descending order")
    public void userSortsItemsInDescendingOrder() {
        categoriesPage = pageFactoryManager.getCategoriesPage();
        categoriesPage.clickSortByButton();
        categoriesPage.clickSortByPriceHighToLowButton();
    }

    @Then("User checks that items are sorted by descending order")
    public void userChecksThatItemsAreSortedByDescendingOrder() {
        List<Integer> actual = categoriesPage.getListOfItemsPrice();
        List<Integer> expected = actual.stream().sorted((x, y) -> y - x).collect(Collectors.toList());
        actual.remove(0);
        expected.remove(0);
        Assert.assertEquals(actual, expected);


    }
    @When("User makes search by keyword {string}")
    public void enterKeyWordToSearchField(final String keyword) {
        homePage.enterTextToSearchField(keyword);
    }

    @Then("User checks that search result contains search keyword {string}")
    public void checkSearchResultContainsKeyword(final String keyword) {
        searchResultsPage = pageFactoryManager.getSearchResultPage();
        SoftAssertions softAssert = new SoftAssertions ();
        searchResultsPage.getTextListFromItemsDescriptionList()
                .forEach(i -> softAssert.assertThat(i.toLowerCase().contains(keyword)));
        softAssert.assertAll();
    }
    @Then("User checks that search result with {string} is visible")
    public void userChecksThatSearchResultWithKeywordIsVisible(final String keyword) {
        searchResultsPage = pageFactoryManager.getSearchResultPage();
        Assert.assertTrue(searchResultsPage.getTextListFromItemsDescriptionList()
                .stream().anyMatch(text -> text.equalsIgnoreCase(keyword)));
    }
    @After
    public void tearDown() {driver.quit();
    }
    @And("user adds item to shopping cart")
    public void addToCartButton() {
        itemPage = pageFactoryManager.getItemPage();
        itemPage.addToCart();
    }
}
