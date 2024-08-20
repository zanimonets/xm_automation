package ui.page.commonresolution;

import org.openqa.selenium.WebDriver;
import ui.module.commonresolution.TradingConditionsModule;
import ui.page.base.BasePage;

public class CompanyProfilePage extends BasePage {

    private TradingConditionsModule tradingConditionsModule;

    public CompanyProfilePage(WebDriver webdriver) {
        super(webdriver);
        this.tradingConditionsModule = new TradingConditionsModule(driver);
    }

    public TradingConditionsModule tradingConditionsModule() {
        return tradingConditionsModule;
    }
}
