package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static java.time.Duration.ofSeconds;

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

    public void click(By byElement) {
        wait.until(ExpectedConditions.elementToBeClickable(byElement)).click();
    }

    public void sendKeys(By byElement, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(byElement)).sendKeys(text);
    }

    public String getText(By byElement) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(byElement)).getText();
    }

    public void moveToElement(WebElement element) {
        actions.moveToElement(element).perform();
    }

    public boolean isElementExist(By byElement) {
        return driver.findElements(byElement).size() > 0;
    }

    public void waitToElement(By byElement) {
        wait.until(ExpectedConditions.presenceOfElementLocated(byElement));
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

            if (item.getText().contains(name)){
                return item;
            }
        }

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
