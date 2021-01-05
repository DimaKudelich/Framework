package test;

import org.testng.annotations.Test;
import page.BasketPage;
import page.ProductPage;
import service.ProductPageDataReader;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketTest extends CommonCondition {
    @Test
    public void addToCartTest() {
        String productPageUrl = ProductPageDataReader.getProductPageUrl();

        ProductPage productPage = new ProductPage(productPageUrl);

        String expectedName = productPage
                .openPage()
                .getProductName();

        String expectedSize = productPage
                .clickOnProductSizeLabel()
                .getProductSizeLabelText();

        BasketPage basketPage = productPage
                .clickOnAddToBasketButton()
                .clickOnGoToBasketButton();

        String actualName = basketPage
                .getProductName();

        String actualSize = basketPage
                .getProductSize();

        assertThat(actualName).contains(expectedName);
        assertThat(actualSize).isEqualTo(expectedSize);
    }
}
