package ui.module.commonresolution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.constants.JSCommands;
import ui.constants.StockCountry;
import ui.module.base.BaseModule;
import ui.util.ElementUtils;
import ui.util.JSExecutor;

public class StocksCFDsTabModule extends BaseModule {

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchInput;

    @FindBy(xpath = "//a[@data-xm-qa-name='cash']")
    private WebElement stocksTabLabel;

    private StocksTableModule stocksTableModule;


    public StocksCFDsTabModule(WebDriver driver) {
        super(driver);
        stocksTableModule = new StocksTableModule(driver);
    }

    public StocksTableModule stocksTableModule() {
        return stocksTableModule;
    }

    public void chooseCountry(StockCountry country) {
        WebElement countryButton = getCountryButtonElement(country);
        JSExecutor.executeScriptOnElement(JSCommands.SCROLL_IN_TO_VIEW, stocksTabLabel);
        countryButton.click();
        ElementUtils.waitUntilElementBecomeActive(countryButton);
    }

    private WebElement getCountryButtonElement(StockCountry country) {
        By xpathLocator  = By.xpath("//button[text()='" + country.getDisplayName() + "']");
        return driver.findElement(xpathLocator);
    }

    public void performSearch(String searchVal) {
        searchInput.sendKeys(searchVal);
    }
}
