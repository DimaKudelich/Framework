package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends AbstractPage {
    private String productPageAddress;

    @FindBy(xpath = "//span[@class='name']")
    private WebElement productName;

    @FindBy(xpath = "//div[@class='j-size-list size-list j-smart-overflow-instance']/label")
    private WebElement productSize;

    @FindBy(xpath = "//button[@class='c-btn-main-lg-v1 j-add-to-card']")
    private WebElement addToBasket;

    @FindBy(xpath = "//a[@class='c-btn-base-lg-v1 j-go-to-basket']")
    private WebElement openBasket;

    private static final By byOpenBasket = By
            .xpath("//a[@class='c-btn-base-lg-v1 j-go-to-basket']");

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

    public ProductPage clickOnProductSizeLabel() {
        this.productSize.click();
        return this;
    }

    public ProductPage clickOnAddToBasketButton() {
        this.addToBasket.click();
        return this;
    }

    public BasketPage clickOnGoToBasketButton() {
        driverWait.until(ExpectedConditions
                .presenceOfElementLocated(byOpenBasket)).click();
        return new BasketPage();
    }

    public String getProductName() {
        return this.productName.getText();
    }
}
