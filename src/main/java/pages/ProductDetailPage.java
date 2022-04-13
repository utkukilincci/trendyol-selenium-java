package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BaseMethods {
    private final By ADD_BASKET_BUTTON = By.className("add-to-basket");
    private final By OPENING_MINI_BASKET = By.cssSelector("[class='basket-preview-container visible']");

    public ProductDetailPage(WebDriver driver){
        super(driver);
    }

    public void switchToProductDetailTab() {
        switchToTab();
    }

    public void clickAddBasket(){
        click(ADD_BASKET_BUTTON);
        waitToElement(OPENING_MINI_BASKET);
    }

    public HomePage closeTheProductDetailPage() {
        closeToTab();
        return new HomePage(driver);
    }
}
