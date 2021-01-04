package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {
    private static final String ADDRESS = "https://by.wildberries.ru/";

    @FindBy(xpath = "//input[@class='sq c-text-md-v1']")
    private WebElement searchInput;

    @FindBy(xpath = "//span[@id='btnSrch']")
    private WebElement searchButton;

    @FindBy(xpath = "//li[@class='item item-delivery']")
    private WebElement freeDeliveryButton;

    public MainPage()
    {
        super();
    }

    @Override
    public MainPage openPage()
    {
        driver.navigate().to(ADDRESS);
        return this;
    }

    public MainPage enterSearchQuery(String query) {
        searchInput.sendKeys(query);
        return this;
    }

    public SearchResultPage searchForQuery() {
        searchButton.click();
        return new SearchResultPage();
    }

    public FreeDeliveryPage openFreeDelivery(){
        this.freeDeliveryButton.click();
        return new FreeDeliveryPage();
    }
}
