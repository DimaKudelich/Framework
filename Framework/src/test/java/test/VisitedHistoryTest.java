package test;

import org.testng.annotations.Test;
import page.ProductPage;
import page.VisitedHistoryPage;
import service.ProductPageDataReader;

import static org.assertj.core.api.Assertions.assertThat;

public class VisitedHistoryTest extends CommonCondition {
    @Test
    public void testPresenceInVisitedAfterVisitingProductPage() {
        String productPageUrl = ProductPageDataReader.getProductPageUrl();

        String expectedProductName = new ProductPage(productPageUrl)
                .openPage()
                .getProductName();

        String actualProductName = new VisitedHistoryPage()
                .openPage()
                .getLastVisitedItemName();

        assertThat(actualProductName).isEqualTo(expectedProductName);
    }
}
