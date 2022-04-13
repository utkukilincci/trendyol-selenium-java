package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TakeMail extends BaseMethods {
    private final String TAKE_EMAIL_URL = "https://10minutemail.net/?lang=tr";
    private final By MAIL_TEXT = By.id("fe_text");

    public TakeMail(WebDriver driver){
        super(driver);
    }

    public String takeMail(){
        navigateUrl(TAKE_EMAIL_URL);

        return getAttribute(MAIL_TEXT,"value");
    }
}
