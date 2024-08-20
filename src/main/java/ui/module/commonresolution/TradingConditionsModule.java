package ui.module.commonresolution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.model.TradingConditions;
import ui.module.base.BaseModule;
import ui.util.ElementUtils;

public class TradingConditionsModule extends BaseModule {

    @FindBy(xpath = "//section[contains(@class,'conditions')]//h2/following-sibling::div")
    private WebElement rootLocator;

 //   private final By rootLocator = By.xpath("//section[contains(@class,'conditions')]//h2/following-sibling::div");
    private final By minMarginPercentageLocator = By.xpath("//td[@data-xm-qa-name='margin_requirement__value']/span/strong");
    private final By symbolsLocator = By.xpath("//td[@data-xm-qa-name='symbols__value']/span");
    private final By descriptionLocator = By.xpath("//td[@data-xm-qa-name='description__value']/span");
    private final By minPriceFluctuationLocator = By.xpath("//td[@data-xm-qa-name='fc_min_price_fluctuation__value']/span");
    private final By valueOfMinPriceFluctuationLocator = By.xpath("//td[@data-xm-qa-name='value_of_minimum_price_fluctuation__value']/span");
    private final By valueOfLotLocator = By.xpath("//td[@data-xm-qa-name='value_one_lot__value']/span");
    private final By spreadAsLowAsLocator = By.xpath("//table[@class='table pull-right']//td[@data-xm-qa-name='spreads_as_low_as__value']/span/strong");
    private final By minMaxTradeSizeLocator = By.xpath("//td[@data-xm-qa-name='min_max_trade_size__value']/span");
    private final By swapValueLongLocator = By.xpath("//td[@data-xm-qa-name='swap_value_in_margin_currency_long__value']/span");
    private final By swapValueShortLocator = By.xpath("//td[@data-xm-qa-name='swap_value_in_margin_currency_short__value']/span");
    private final By limitAndStopLevelsLocator = By.xpath("//td[@data-xm-qa-name='limit_and_stop_levels__title']/span");
    private final By totalVolumeLimitLocator = By.xpath("//td[@data-xm-qa-name='cryptocurrency_total_volume_limit_new__title']/span");

    public TradingConditionsModule(WebDriver driver) {
        super(driver);
    }

    public TradingConditions getTradingConditionsCombinedTable() {
        ElementUtils.waitUntilVisible(rootLocator);

        return TradingConditions.builder()
                .symbols(driver.findElement(symbolsLocator).getText())
                .description(driver.findElement(descriptionLocator).getText())
                .spreadAsLowAs(driver.findElement(spreadAsLowAsLocator).getText())
                .minMaxTradeSize(driver.findElement(minMaxTradeSizeLocator).getText())
                .minMarginPercentage(driver.findElement(minMarginPercentageLocator).getText())
                .swapValueLong(driver.findElement(swapValueLongLocator).getText())
                .swapValueShort(driver.findElement(swapValueShortLocator).getText())
                .limitAndStopLevels(driver.findElement(limitAndStopLevelsLocator).getText())
                .build();
    }
}
