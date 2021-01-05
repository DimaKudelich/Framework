package page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasketPage extends AbstractPage {
    private static final By byProductName = By.xpath("//span[@class='good-name']");
    private static final By byProductSize = By.xpath("//span[@class='size-item']");

    public BasketPage()
    {
        super();
    }

    @Override
    public BasketPage openPage()
    {
        logger.error("Basket page cant be opened by itself");
        throw new RuntimeException();
    }

    public String getProductName() {
        return driverWait.until(ExpectedConditions
                .presenceOfElementLocated(byProductName)).getText();
    }

    public String getProductSize() {
        return driverWait.until(ExpectedConditions
                .presenceOfElementLocated(byProductSize)).getText().substring(8);
    }
}
