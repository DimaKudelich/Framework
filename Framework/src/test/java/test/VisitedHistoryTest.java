package test;

import org.testng.annotations.Test;
import page.ProductPage;
import page.VisitedHistoryPage;

import static org.assertj.core.api.Assertions.assertThat;

public class VisitedHistoryTest extends CommonCondition {
    @Test
    public void testPresenceInVisitedAfterVisitingProductPage() {
        String productPageUrl = "https://by.wildberries.ru/catalog/13612368/detail.aspx";

        String expectedProductName = new ProductPage(productPageUrl)
                .openPage()
                .getProductName();

        String actualProductName = new VisitedHistoryPage()
                .openPage()
                .getLastVisitedItemName();

        assertThat(actualProductName).isEqualTo(expectedProductName);
    }
}
