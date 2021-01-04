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
        logger.info("Opened search results page " + driver.getCurrentUrl());
    }

    @Override
    protected SearchResultPage openPage() {
        logger.error("Cannot open SearchResultsPage by itself! Throwing exception");
        throw new RuntimeException("Cannot open SearchResultsPage by itself!");
    }

    public List<String> getListOfProductNames() {
        driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byProductNamesLocator));
        List<String> productNameList = new ArrayList<>();
        for(WebElement textElement : productNamesList) {
            productNameList.add(textElement.getText());
        }
        return productNameList;
    }
}
