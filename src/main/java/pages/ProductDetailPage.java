package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BaseMethods {
    private final By PRODUCT_NAME = By.cssSelector(".pr-new-br > span");
    private final By ADD_BASKET_BUTTON = By.className("add-to-basket");
    private final By SUCCESS_ADD_BASKET_BUTTON = By.className("add-to-basket-button-text-success");

    public ProductDetailPage(WebDriver driver){
        super(driver);
    }

    public void switchToProductDetailTab() {
        switchToTab();
    }

    public String getProductName(){
        return getText(PRODUCT_NAME);
    }

    public void clickAddBasket(){
        click(ADD_BASKET_BUTTON);
        waitToElement(SUCCESS_ADD_BASKET_BUTTON);
    }

    public HomePage closeTheProductDetailPage() {
        closeToTab();
        return new HomePage(driver);
    }
}
