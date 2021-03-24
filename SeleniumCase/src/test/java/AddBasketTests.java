import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductList;

public class AddBasketTests extends BaseTest{

    @Test
    public void succesfulAddToBasket(){
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();
        ProductList productList =  homePage.goToTvDisplayAndSound();
        productList.addToBasketFirstProduct();
        String title1 = productList.getFirstProductTitle();
        String title2 = productList.getBasketProductTitle();
        Assert.assertEquals(title1,title2);
    }
}
