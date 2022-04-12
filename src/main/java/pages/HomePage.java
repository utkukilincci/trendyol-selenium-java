package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BaseMethods {

    Actions actions;

    private final String HOME_PAGE_URL = "https://www.trendyol.com/";
    private final By HOME_PAGE_POP_UP = By.className("modal-close");
    private final By ACCOUNT_BUTTON = By.className("account-user");
    private final By CATEGORIES = By.cssSelector(".category-header");
    private final By SUB_CATEGORIES = By.cssSelector(".sub-category-header");
    private final By BASKET_BUTTON = By.className("account-basket");

    public HomePage(WebDriver driver){
        super(driver);
        actions = new Actions(driver);
    }

    public void goToHomePage(){
        driver.get(HOME_PAGE_URL);

        if(isElementExist(HOME_PAGE_POP_UP)) {
            click(HOME_PAGE_POP_UP);
        }
    }

    public String getAccountText() {
        return getText(ACCOUNT_BUTTON);
    }

    public ProductList goToSubCategoryInCategory(String categoryName, String subCategory){
        WebElement category = getElementWithTextInList(CATEGORIES, categoryName);
        moveToElement(category);

        getElementWithTextInList(SUB_CATEGORIES, subCategory).click();

        return new ProductList(driver);
    }

    public BasketPage goToBasketPage() {
        click(BASKET_BUTTON);

        return new BasketPage(driver);
    }
}
