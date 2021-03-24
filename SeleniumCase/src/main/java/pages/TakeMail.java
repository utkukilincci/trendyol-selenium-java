package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TakeMail extends BaseMethods {


    private String url = "https://10minutemail.net/?lang=tr";
    private By mailText = By.id("fe_text");

    public TakeMail(WebDriver driver){
        super(driver);
    }

    public String takeMail(){

        driver.get(url);
        return driver.findElement(mailText).getAttribute("value");
    }

}
