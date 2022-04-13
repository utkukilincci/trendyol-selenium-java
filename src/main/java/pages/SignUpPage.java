package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BaseMethods {
    private final By SIGN_UP_BUTTON = By.cssSelector(".q-layout .right");
    private final By MAIL_TEXT_BOX = By.id("register-email");
    private final By PASSWORD_TEXT_BOX = By.id("register-password-input");
    private final By SUBMIT_BUTTON = By.className("submit");
    private final By PERSONAL_DATA_CHECK_BOX = By.cssSelector(".personal-checkbox .ty-check");
    private final By EMAIL_VERIFY_MODAL = By.cssSelector(".email-verify-modal");

    public SignUpPage(WebDriver driver){
        super(driver);
    }

    public void clickSignUpButton() {
        click(SIGN_UP_BUTTON);
    }

    public void validSignUp(String mail, String password){
        sendKeys(MAIL_TEXT_BOX, mail);
        sendKeys(PASSWORD_TEXT_BOX, password);
        click(PERSONAL_DATA_CHECK_BOX);
        click(SUBMIT_BUTTON);
    }

    public Boolean isVerifyModalExists() {
        return isElementExist(EMAIL_VERIFY_MODAL);
    }
}
