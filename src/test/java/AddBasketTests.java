import org.testng.annotations.Test;
import pages.BasketPage;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AddBasketTests extends BaseTest{
    @Test
    public void successfulAddToBasketE2E(){
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();

        ProductList productList =  homePage.goToSubCategoryInCategory("ELEKTRONIK", "TV & Görüntü & Ses");

        ProductDetailPage productDetailPage = productList.clickFirstProduct();
        productDetailPage.switchToProductDetailTab();
        String productTitle = productDetailPage.getProductName();
        productDetailPage.clickAddBasket();

        homePage = productDetailPage.closeTheProductDetailPage();

        BasketPage basketPage = homePage.goToBasketPage();
        String productTitleInBasket = basketPage.getProductTitleInBasket();

        assertThat(
                "When user add product to basket, should be able to see product in basket  ",
                productTitleInBasket,
                containsString(productTitle)
        );
    }
}
