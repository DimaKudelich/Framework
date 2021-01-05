package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='end-n']/div/input")
    private WebElement maxPriceInput;

    private static final By byMaxPriceInput = By.xpath("//div[@class='end-n']/div/input");

    private static final By byProductNamesLocator = By.xpath("//span[@class='goods-name c-text-sm']");

    @FindBy (xpath = "//span[@class='goods-name c-text-sm']")
    List<WebElement> productNamesList;

    private static final By byProductPriceLocator = By.xpath("//ins[@class='lower-price']");

    @FindBy (xpath = "//ins[@class='lower-price']")
    List<WebElement> productPriceList;

    public SearchResultPage() {
        super();
    }

    @Override
    protected SearchResultPage openPage() {
        logger.error("Search result's page cant be opened by itself");
        throw new RuntimeException("Cannot open SearchResultsPage by itself!");
    }

    public List<String> getResultList() {
        driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byProductNamesLocator));

        List<String> productNameList = new ArrayList<>();
        for(WebElement textElement : productNamesList) {
            productNameList.add(textElement.getText());
        }

        return productNameList;
    }

    public SearchResultPage enterMaxPrice(String maxPrice){
        logger.info("Enter a max price as filter");
        driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byMaxPriceInput));

        this.maxPriceInput.sendKeys(Keys.CONTROL + "a");
        this.maxPriceInput.sendKeys(Keys.DELETE);
        this.maxPriceInput.sendKeys(maxPrice);
        this.maxPriceInput.sendKeys(Keys.ENTER);

        return this;
    }

    public List<String> getListOfProductPrices() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byProductPriceLocator));
        List<String> productPrices = new ArrayList<>();

        for(WebElement element : productPriceList) {
            productPrices.add(element.getText());
        }

        return productPrices;
    }
}
