package ui.page.commonresolution;

import org.openqa.selenium.WebDriver;
import ui.module.commonresolution.StocksCFDsTabModule;
import ui.page.base.BasePage;


public class StocksPage extends BasePage {

    private StocksCFDsTabModule stocksCFDsTabModule;


    public StocksPage(WebDriver driver) {
        super(driver);
        this.stocksCFDsTabModule = new StocksCFDsTabModule(driver);
    }

    public StocksCFDsTabModule stocksCFDsTabModule() {
       return stocksCFDsTabModule;
    }
}
