import pages.HomePage;
import pages.SignUpPage;
import pages.TakeMail;
import org.testng.Assert;
import org.testng.annotations.Test;
import user.User;

public class SignUpTests extends BaseTest {


    @Test
    public void successfulSignUp(){
        String expectedAccountName = "Hesabım";
        TakeMail takeMail = new TakeMail(driver);
        User user = new User();
        user.setEmail(takeMail.takeMail());
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.goToSignUpPage();
        HomePage homePage = signUpPage.signUp(user.getEmail(), user.getPassword());
        String accountText =  homePage.getAccountText();
        Assert.assertEquals(accountText, expectedAccountName);
    }

}
