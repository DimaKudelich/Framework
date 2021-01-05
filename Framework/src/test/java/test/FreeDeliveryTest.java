package test;

import org.testng.annotations.Test;
import page.MainPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FreeDeliveryTest extends CommonCondition {
    @Test
    public void freeDeliveryConditionTest() {
        String expectedDeliveryCondition = "Бесплатно";

        String actualDeliveryCondition = new MainPage()
                .openPage()
                .openFreeDelivery()
                .clickOnFirstAddressBox()
                .getFirstAddressBoxDeliveryCondition();

        assertThat(expectedDeliveryCondition)
                .isEqualTo(actualDeliveryCondition);
    }
}
