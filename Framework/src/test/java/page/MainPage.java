package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends AbstractPage {
    private static final String BASE_URL = "https://by.wildberries.ru/";

    @FindBy(xpath = "//input[@class='sq c-text-md-v1']")
    private WebElement inputTab;

    @FindBy(xpath = "//span[@id='btnSrch']")
    private WebElement searchButton;

    public MainPage()
    {
        super();
    }

    @Override
    public MainPage openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.info("Opened page " + BASE_URL);
        return this;
    }

    public MainPage enterSearchQuery(String query) {
        inputTab.sendKeys(query);
        return this;
    }

    public SearchResultPage clickSearchButton() {
        searchButton.click();
        return new SearchResultPage();
    }
}
