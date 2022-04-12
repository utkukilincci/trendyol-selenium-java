package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductList extends BaseMethods {

    private final By PRODUCTS = By.className("p-card-chldrn-cntnr");
    private final By PRODUCT_DETAIL_POPUP = By.className("popup");
    private final By EMPTY = By.xpath("//html");

    public ProductList(WebDriver driver){
        super(driver);
    }

    public ProductDetailPage clickFirstProduct(){
        if(isElementExist(PRODUCT_DETAIL_POPUP)) {
            click(EMPTY);
        }
        getElementByIndex(PRODUCTS,0).click();
        return new ProductDetailPage(driver);
    }
}
