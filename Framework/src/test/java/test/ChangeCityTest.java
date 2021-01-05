package test;

import org.testng.annotations.Test;
import page.MainPage;
import page.ProductPage;

import static org.assertj.core.api.Assertions.assertThat;

public class ChangeCityTest extends CommonCondition {
    @Test
    public void changeCityTest() throws InterruptedException {
        MainPage mainPage = new MainPage().openPage().openCities();

        Thread.sleep(1000);
        String expectedCity = mainPage.getNewCityName();

        mainPage = mainPage.chooseNewCity();
        Thread.sleep(1000);

        String actualCity = mainPage.getCurrentCityName();

        assertThat(actualCity).isEqualTo(expectedCity);
    }
}
