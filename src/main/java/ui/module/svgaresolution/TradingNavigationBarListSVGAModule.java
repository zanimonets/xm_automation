package ui.module.svgaresolution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.constants.JSCommands;
import ui.module.base.BaseModule;
import ui.util.JSExecutor;

public class TradingNavigationBarListSVGAModule extends BaseModule {

    @FindBy(xpath = "//div[@id='tradingMenu']//a[@href='https://www.xm.com/stocks']")
    private WebElement stocksOption;

    public TradingNavigationBarListSVGAModule(WebDriver webdriver) {
        super(webdriver);
    }

    public void clickStocksOption() {
        JSExecutor.executeScriptOnElement(JSCommands.SCROLL_IN_TO_VIEW, stocksOption);
        stocksOption.click();
    }
}
