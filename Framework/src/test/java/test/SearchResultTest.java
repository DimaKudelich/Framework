package test;

import org.testng.annotations.Test;
import page.MainPage;
import service.SearchPageDataReader;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultTest extends CommonCondition {
    @Test
    public void testSearchForProduct() {
        String currentQuery = SearchPageDataReader.getSearchQuery();
        List<String> actualProductNames = new MainPage()
                .openPage()
                .enterSearchQuery(currentQuery)
                .searchForQuery()
                .getResultList();

        assertThat(actualProductNames).allMatch(item -> item.contains(currentQuery));
    }

    @Test
    public void testSearchForProductWrong() {
        String correctQuery = "Кроссовки";
        String wrongLayoutQuery = "rhjccjdrb";
        List<String> actualProductNames = new MainPage()
                .openPage()
                .enterSearchQuery(wrongLayoutQuery)
                .searchForQuery()
                .getResultList();
        assertThat(actualProductNames).allMatch(item -> item.contains(correctQuery));
    }
}
