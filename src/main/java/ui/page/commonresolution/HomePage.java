package ui.page.commonresolution;

import org.openqa.selenium.WebDriver;
import ui.module.commonresolution.TopMenuModule;
import ui.page.base.BasePage;
import ui.module.commonresolution.TradingDropDownModule;

public class HomePage extends BasePage {

    private TopMenuModule topMenuModule;
    private TradingDropDownModule tradingDropDownModule;

    public HomePage(WebDriver driver) {
        super(driver);
        this.topMenuModule = new TopMenuModule(driver);
        this.tradingDropDownModule = new TradingDropDownModule(driver);
    }

    public TopMenuModule topMenuModule() {
        return topMenuModule;
    }

    public TradingDropDownModule tradingDropDownModule() {
        return tradingDropDownModule;
    }
}
