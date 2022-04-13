import pages.HomePage;
import pages.SignUpPage;
import pages.TakeMail;
import org.testng.annotations.Test;
import models.User;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SignUpTests extends BaseTest {

    @Test
    public void shouldBeShownEmailVerifyModalWhenSigningUp(){
        TakeMail takeMail = new TakeMail(driver);
        User user = new User();
        user.setEmail(takeMail.takeMail());

        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();

        SignUpPage signUpPage = homePage.clickAccountButton();
        signUpPage.clickSignUpButton();
        signUpPage.validSignUp(user.getEmail(), user.getPassword());

        assertThat(
            "When user try to sign up, should be able to see email verify modal ",
            signUpPage.isVerifyModalExists(),
            is(true)
        );
    }
}
