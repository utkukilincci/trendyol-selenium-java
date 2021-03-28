import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.HomePage;
import pages.ProductList;

public class AddBasketTests extends BaseTest{

    @Test
    public void succesfulAddToBasket(){
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();
        ProductList productList =  homePage.goToTvDisplayAndSound();
        productList.addToBasketFirstProduct();
        String productTitle = productList.getFirstProductTitle();
        BasketPage basketPage = productList.clickBasket();
        String productTitleInBasket = basketPage.getProductTitleInBasket();
        Assert.assertTrue(productTitleInBasket.contains(productTitle));
    }
}
