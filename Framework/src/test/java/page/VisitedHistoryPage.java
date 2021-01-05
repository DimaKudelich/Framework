package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VisitedHistoryPage extends AbstractPage {
    private static final String BASE_URL = "https://by.wildberries.ru/catalog/recent";

    @FindBy(xpath = "//span[@class='goods-name c-text-sm']")
    WebElement lastVisitedItemName;

    public VisitedHistoryPage()
    {
        super();
    }

    @Override
    public VisitedHistoryPage openPage()
    {
        logger.info("Open history page");
        driver.navigate().to(BASE_URL);
        return this;
    }

    public String getLastVisitedItemName() {
        return lastVisitedItemName.getText();
    }
}