package test;

import org.testng.annotations.Test;
import page.MainPage;
import service.PriceService;
import service.SearchPageDataReader;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FilterTest extends CommonCondition {
    @Test
    public void priceFilterTest() {
        String searchQuery = SearchPageDataReader.getSearchQuery();
        String filterMaxPrice = SearchPageDataReader.getFilterMaxPrice();

        List<String> prisesOfResult = new MainPage()
                .openPage()
                .enterSearchQuery(searchQuery)
                .searchForQuery()
                .enterMaxPrice(filterMaxPrice)
                .getListOfProductPrices();

        assertThat(PriceService.getIntFromPrice(prisesOfResult))
                .allMatch(item -> item <= Integer.parseInt(filterMaxPrice));
    }
}
