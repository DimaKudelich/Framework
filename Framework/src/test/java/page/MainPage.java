package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    //тестовый метод смены города

    @FindBy(xpath = "//li[@class = 'geocity item']")
    private WebElement changeCityButton;

    @FindBy(xpath = "//li[@data-city-id = '1985372']/span")
    private WebElement newCity;

    public String getCurrentCityName(){
        driverWait.until(ExpectedConditions.invisibilityOf(newCity));
        return changeCityButton.getText();
    }

    public MainPage openCities(){
        changeCityButton.click();
        return this;
    }

    public String getNewCityName(){
        return driverWait.until(ExpectedConditions.visibilityOf(newCity)).getText();
    }

    public MainPage chooseNewCity(){
        newCity.click();
        return this;
    }
}
