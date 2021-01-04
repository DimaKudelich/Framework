package test;

import org.testng.annotations.Test;
import page.BasketPage;
import page.ProductPage;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketTest extends CommonCondition {
    @Test
    public void addToCartTest() {
        String productPageUrl = "https://by.wildberries.ru/catalog/13612368/detail.aspx";

        ProductPage productPage = new ProductPage(productPageUrl);

        String expectedName = productPage
                .openPage()
                .getProductName();

        String expectedSize = productPage
                .clickOnProductSizeLabel()
                .getProductSizeLabelText();

        BasketPage cartPage = productPage
                .clickOnAddToCartButton()
                .clickOnGoToCartButton();

        String actualName = cartPage
                .getProductName();

        String actualSize = cartPage
                .getProductSize();

        assertThat(actualName).contains(expectedName);
        assertThat(actualSize).isEqualTo(expectedSize);
    }
}
