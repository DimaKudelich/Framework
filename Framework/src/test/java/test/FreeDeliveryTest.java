package test;

import org.testng.annotations.Test;
import page.MainPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FreeDeliveryTest extends CommonCondition {
    @Test
    public void feeDeliveryConditionTest() {
        String deliveryCondition = "Бесплатно";

        String expectedDeliveryCondition = new MainPage()
                .openPage()
                .openFreeDelivery()
                .clickOnFirstAddressBox()
                .getFirstAddressBoxDeliveryCondition();

        assertThat(deliveryCondition)
                .isEqualTo(expectedDeliveryCondition);

    }
}
