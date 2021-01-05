package page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FreeDeliveryPage extends AbstractPage {
    private static final By byFirstAddressLabel = By.xpath("//div[@class='address-list-item']");
    private static final By byFirstAddressBoxDeliveryCondition = By.xpath("//div[@class='balloon-content-info']/span[@class='wb']");


    public FreeDeliveryPage clickOnFirstAddressBox(){
        logger.info("CLick on first delivery address");
        driverWait.until(ExpectedConditions
                .presenceOfElementLocated(byFirstAddressLabel)).click();
        return this;
    }

    public String getFirstAddressBoxDeliveryCondition(){
        return driverWait.until(ExpectedConditions
                .presenceOfElementLocated(byFirstAddressBoxDeliveryCondition)).getText();
    }

    public FreeDeliveryPage() {
        super();
    }

    @Override
    protected SearchResultPage openPage() {
        logger.error("Delivery page cant be opened by itself");
        throw new RuntimeException("Cannot open SearchResultsPage by itself!");
    }
}