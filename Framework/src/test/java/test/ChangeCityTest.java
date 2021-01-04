package test;

import org.testng.annotations.Test;
import page.ProductPage;

import static org.assertj.core.api.Assertions.assertThat;

public class ChangeCityTest extends CommonCondition {
    @Test
    public void changeRegionFromMinskToBaranovichi() {
        String productPageUrl = "https://by.wildberries.ru/catalog/13612368/detail.aspx";

        ProductPage productPage = new ProductPage(productPageUrl);

        String newRegionName  = productPage
                .openPage()
                .clickOnCurrentRegionSpanInNavBar()
                .getNewRegionSpanInPopUpName();


        String expectedNewRegionName = productPage
                .clickOnNewRegionSpanInPopUp()
                .getCurrentRegionNearTheProductName();

        assertThat(newRegionName).isEqualTo(expectedNewRegionName);
    }
}
