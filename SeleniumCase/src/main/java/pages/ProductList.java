package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ProductList extends BaseMethods {

    private By addToBasket = By.className("add-to-basket-button");
    private By prdocutTitle = By.className("prdct-desc-cntnr-name");
    private By basketBtn = By.className("account-basket");

    public ProductList(WebDriver driver){
        super(driver);
    }

    public void addToBasketFirstProduct(){
        List<WebElement> productList =  driver.findElements(addToBasket);
        productList.get(0).click();
    }

    public String getFirstProductTitle(){
        List<WebElement> list = driver.findElements(prdocutTitle);
        String title = list.get(0).getAttribute("title");
        return title;
    }


    public BasketPage clickBasket(){
        click(basketBtn,5);
        return new BasketPage(driver);
    }
}
