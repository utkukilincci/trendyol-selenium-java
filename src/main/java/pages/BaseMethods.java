package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static java.time.Duration.ofSeconds;
import static utils.LogUtils.logInfo;

public class BaseMethods {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    protected String firstTab;
    protected ArrayList<String> newTab;

    public BaseMethods(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(this.driver);
        this.wait = new WebDriverWait(driver, ofSeconds(5));
        firstTab = driver.getWindowHandle();
    }

    public void navigateUrl(String url) {
        driver.get(url);
    }

    public void click(By element) {
        waitToElement(element).click();
    }

    public void sendKeys(By element, String text) {
        waitToElement(element).sendKeys(text);
    }

    public String getText(By element) {
        return waitToElement(element).getText();
    }

    public String getAttribute(By element, String attribute) {
        return waitToElement(element).getAttribute(attribute);
    }

    public void moveToElement(WebElement element) {
        actions.moveToElement(element).perform();
    }

    public boolean isElementExist(By element) {
        return driver.findElements(element).size() > 0;
    }

    public WebElement waitToElement(By element) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void scrollToPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }

    public WebElement getElementByIndex(By element, int index){
        List<WebElement> elements = driver.findElements(element);

        return elements.get(index);
    }

    public WebElement getElementWithTextInList(By element, String name){
        List<WebElement> elements = driver.findElements(element);

        for(WebElement item : elements){

            logInfo(item.getText());
            if (item.getText().contains(name)){
                return item;
            }
        }

        logInfo("Given text is not exists");
        return null;
    }

    public void switchToTab() {
        newTab = new ArrayList<>(driver.getWindowHandles());
        newTab.remove(firstTab);
        driver.switchTo().window(newTab.get(0));
    }

    public void closeToTab() {
        driver.close();
        driver.switchTo().window(firstTab);
    }
}
