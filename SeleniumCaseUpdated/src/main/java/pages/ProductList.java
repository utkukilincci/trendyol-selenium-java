package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ProductList extends BaseMethods {

    Actions actions;

    private By addToBasket = By.className("add-to-basket-button");
    private By prdocutTitle = By.className("prdct-desc-cntnr-name");
    private By basket = By.className("account-basket");
    private By inBasketProductTitle = By.className("pb-item");

    public ProductList(WebDriver driver){
        super(driver);
    }

    /*public void scrollToThirdPage(){
        String url = "";
        while(!url.contains("pi=3")){
            scrollToPage();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            url = driver.getCurrentUrl();
        }

    }*/

    public void addToBasketFirstProduct(){
        List<WebElement> productList =  driver.findElements(addToBasket);
        productList.get(0).click();
    }

    public String getFirstProductTitle(){
        List<WebElement> list = driver.findElements(prdocutTitle);
        String title = list.get(0).getAttribute("title");
        return title;
    }

    public String getBasketProductTitle(){
        click(basket,5);
        String basketProductTitle = driver.findElement(inBasketProductTitle).getAttribute("title");
        return basketProductTitle;
    }
}
