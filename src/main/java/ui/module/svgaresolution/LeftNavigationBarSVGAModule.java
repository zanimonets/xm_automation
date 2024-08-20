package ui.module.svgaresolution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.module.base.BaseModule;
import ui.util.ElementUtils;

public class LeftNavigationBarSVGAModule extends BaseModule {

    @FindBy(xpath = "//a[@aria-controls='tradingMenu']")
    private WebElement traidingMenuOption;

    private TradingNavigationBarListSVGAModule tradingNavigationBarListSVGAModule;

    public LeftNavigationBarSVGAModule(WebDriver driver) {
        super(driver);
        tradingNavigationBarListSVGAModule = new TradingNavigationBarListSVGAModule(driver);
    }

    public TradingNavigationBarListSVGAModule tradingNavigationBarListSVGAModule() {
        return tradingNavigationBarListSVGAModule;
    }

    public void clickTradingMenuOption() {
        ElementUtils.waitUntilVisible(traidingMenuOption);
        traidingMenuOption.click();
    }
}
