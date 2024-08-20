package ui.module.commonresolution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.module.base.BaseModule;

public class TradingDropDownModule extends BaseModule {

    @FindBy(xpath = "//li[@class='menu-stocks']/a")
    private WebElement stocksOption;

    public TradingDropDownModule(WebDriver webdriver) {
        super(webdriver);
    }

    public void clickStocksOption() {
        stocksOption.click();
    }
}
