package ui.module.commonresolution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.module.base.BaseModule;

public class TopMenuModule extends BaseModule {

    @FindBy(xpath = "//li[@class='main_nav_trading']/a")
    private WebElement traidingOption;

    public TopMenuModule(WebDriver driver) {
        super(driver);
    }

    public void clickTradingOption() {
      //  waitForElementVisible(addNewDashBoardBtn);
        traidingOption.click();
    }
}
