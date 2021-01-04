package test;

import org.testng.annotations.Test;
import page.ProductPage;

import static org.assertj.core.api.Assertions.assertThat;

public class ChangeCityTest extends CommonCondition {
    @Test
    public void changeCityTest() {
        String productPageUrl = "https://by.wildberries.ru/catalog/16363902/detail.aspx";

        ProductPage productPage = new ProductPage(productPageUrl);

        String newRegionName  = productPage
                .openPage()
                .clickOnCurrentRegionSpanInNavBar()
                .getNewRegionSpanInPopUpName();

        System.out.println(newRegionName);

        String expectedNewRegionName = productPage
                .clickOnNewRegionSpanInPopUp()
                .getCurrentRegionNearTheProductName();

        assertThat(newRegionName).isEqualTo(expectedNewRegionName);
    }
}
