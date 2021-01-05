package test;

import org.testng.annotations.Test;
import page.MainPage;
import page.ProductPage;

import static org.assertj.core.api.Assertions.assertThat;

public class ChangeCityTest extends CommonCondition {
    @Test
    public void changeCityTest() throws InterruptedException {
        MainPage mainPage = new MainPage();

        String expectedCity = mainPage.
                openPage().
                openCities().
                getNewCityName();

        String actualCity = mainPage.
                chooseNewCity().
                getCurrentCityName();

        assertThat(actualCity).isEqualTo(expectedCity);
    }
}
