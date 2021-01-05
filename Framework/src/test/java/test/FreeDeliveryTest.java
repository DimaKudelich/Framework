package test;

import org.testng.annotations.Test;
import page.MainPage;
import service.DeliveryPageDataReader;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FreeDeliveryTest extends CommonCondition {
    @Test
    public void freeDeliveryConditionTest() {
        String expectedDeliveryCondition = DeliveryPageDataReader.getDeliveryCondition();

        String actualDeliveryCondition = new MainPage()
                .openPage()
                .openFreeDelivery()
                .clickOnFirstAddressBox()
                .getFirstAddressBoxDeliveryCondition();

        assertThat(expectedDeliveryCondition)
                .isEqualTo(actualDeliveryCondition);
    }
}
