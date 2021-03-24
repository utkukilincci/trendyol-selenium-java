package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BaseMethods {

    Actions actions;

    private String homePageUrl = "https://www.trendyol.com/";
    private By homePagePopUp = By.className("fancybox-close");
    private By accountButtonBy = By.className("account-user");
    private By electronicField = By.cssSelector("a[href='/butik/liste/elektronik']");
    private By tvDisplayAndSound = By.partialLinkText("TV & Görüntü & Ses");


    public HomePage(WebDriver driver){
        super(driver);
        actions = new Actions(driver);
    }

    public void goToHomePage(){
        driver.get(homePageUrl);
        click(homePagePopUp,3);
    }

    public String getAccountText() {
        return getText(accountButtonBy);
    }

    public ProductList goToTvDisplayAndSound(){
        moveToElement(electronicField);
        click(tvDisplayAndSound,3);
        return new ProductList(driver);
    }
}
