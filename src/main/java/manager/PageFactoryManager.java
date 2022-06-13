package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }

    public SearchResultsPage getSearchResultPage() {return new SearchResultsPage(driver);}

    public ItemPage getItemPage() {return new ItemPage(driver);}

    public ShoppingCartPage getShoppingCartPage () {return new ShoppingCartPage(driver);}

    public CategoriesPage getCategoriesPage() {
        return new CategoriesPage(driver);
    }

}
