package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends AbstractPage {
    private String productPageAddress;

    @FindBy(xpath = "//div[@class='j-size-list size-list j-smart-overflow-instance']/label")
    private WebElement productSize;

    @FindBy(xpath = "//span[@class='geo j-geocity-text']")
    private WebElement currentRegion;

    @FindBy(xpath = "//li[@data-city-id='1985372']/span")
    private WebElement newRegion;

    @FindBy(xpath = "//span[@class='name']")
    private WebElement productName;

    @FindBy(xpath = "//button[@class='c-btn-main-lg-v1 j-add-to-card']")
    private WebElement addToBasket;

    @FindBy(xpath = "//a[@class='c-btn-base-lg-v1 j-go-to-basket']")
    private WebElement openBasket;

    private static final By byOpenBasket = By
            .xpath("//a[@class='c-btn-base-lg-v1 j-go-to-basket']");

    private static final By byCurrentRegion = By.xpath("//span[@class='delivery-cond-locality']");

    private static final By byNewRegion = By.xpath("//li[@data-city-id='1985372']/span");

    public ProductPage(String pageAddress) {
        super();
        this.productPageAddress = pageAddress;
    }

    public ProductPage() {
        super();
    }

    public String getProductSizeLabelText() {
        return this.productSize.getText();
    }

    @Override
    public ProductPage openPage() {
        driver.navigate().to(productPageAddress);
        return this;
    }

    public ProductPage clickOnProductSizeLabel(){
        this.productSize.click();
        return this;
    }

    public ProductPage clickOnAddToCartButton(){
        this.addToBasket.click();
        return this;
    }

    public BasketPage clickOnGoToCartButton(){
        driverWait.until(ExpectedConditions
                .presenceOfElementLocated(byOpenBasket)).click();
        return new BasketPage();
    }

    public String getProductName(){
        return this.productName.getText();
    }


    public ProductPage clickOnCurrentRegionSpanInNavBar(){
        this.currentRegion.click();
        return this;
    }

    public ProductPage clickOnNewRegionSpanInPopUp(){
        driverWait.until(ExpectedConditions
                .presenceOfElementLocated(byNewRegion)).click();
        return this;
    }

    public String getNewRegionSpanInPopUpName(){
        return  driverWait.until(ExpectedConditions
                .presenceOfElementLocated(byNewRegion)).getText();
    }

    public String getCurrentRegionNearTheProductName(){
        return  driverWait.until(ExpectedConditions
                .presenceOfElementLocated(byCurrentRegion)).getText();
    }
}
