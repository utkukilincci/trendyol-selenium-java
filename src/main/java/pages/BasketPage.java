package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BaseMethods{
    private final By BASKET_ITEM = By.className("pb-item");

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public String getProductNameInBasket(){
        return getText(BASKET_ITEM);
    }
}
