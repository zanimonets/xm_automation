package ui.module.commonresolution;

import core.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.constants.JSCommands;
import ui.driver.DriverManager;
import ui.model.StockData;
import ui.module.base.BaseModule;
import ui.resolution.ResolutionConstants;
import ui.util.JSExecutor;
import ui.util.WaitUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StocksTableModule extends BaseModule {

    By rootRowsElement = By.xpath("//table[@id='DataTables_Table_0']/tbody");

    public StocksTableModule(WebDriver driver) {
        super(driver);
    }


    public void clickReadMoreBtnByCompany(String company) {
        WaitUtil.sleep(500);

        String baseElement = "//td[contains(text(), '" + company + "')]";

        if (DriverManager.getResolution().equals(ResolutionConstants.XGA)) {
            By readMoreHiddenBtn = By.xpath("//tr[@class='child']//a[normalize-space(text())='Read More']");
            driver.findElement(By.xpath(baseElement)).click();
            driver.findElement(readMoreHiddenBtn).click();
        } else if (DriverManager.getResolution().equals(ResolutionConstants.SVGA)) {
            By readMoreHiddenBtn = By.xpath("//tr[@class='child']//a[normalize-space(text())='Read More']");

            driver.findElement(readMoreHiddenBtn).click();
        } else {
            By readMoreBtn = By.xpath(baseElement + "/following-sibling::td[@data-xm-qa-name='url']/a");
            driver.findElement(readMoreBtn).click();
        }
    }

    public void scrollAndExpandRow(String company) {
        String baseElement = "//td[contains(text(), '" + company + "')]";
        JSExecutor.executeScriptOnElement(JSCommands.SCROLL_IN_TO_VIEW, driver.findElement(By.xpath(baseElement)));
        driver.findElement(By.xpath(baseElement)).click();
    }

    public List<StockData> parseTable() {
        List<StockData> stockDataList = new ArrayList<>();

        WebElement table = driver.findElement(rootRowsElement);
        List<WebElement> rows = table.findElements(By.xpath(".//tr[1]"));
        List<String> cellTextsFirstPart = null;
        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            List<WebElement> cells = row.findElements(By.xpath(".//td[not(@data-xm-qa-name='url')]"));

            cellTextsFirstPart = cells.stream()
                    .map(WebElement::getText)
                    .collect(Collectors.toList());
        }

        List<WebElement> rootChildSecondPart = table.findElements(By.xpath(".//tr[@class='child']"));
        List<String> cellTextsSecondPart = new ArrayList<>();
        if (!rootChildSecondPart.isEmpty()) {
            cellTextsSecondPart = table.findElements(By.xpath(".//tr[@class='child']//span[@class='dtr-data'][not(a)]")).stream().map(WebElement::getText)
                    .collect(Collectors.toList());
        }

        List<String> tableValues = ArrayUtils.mergeLists(ArrayUtils.removeEmptyString(cellTextsFirstPart), cellTextsSecondPart);

        String symbolWithDescription = tableValues.get(0);
        String mt5Symbol = tableValues.get(1);
        String spread = tableValues.get(2);
        String minMaxTradeSize = tableValues.get(3);
        String minMarginPercentage = tableValues.get(4);
        String longSwapValue = tableValues.get(5);
        String shortSwapValue = tableValues.get(6);
        String limitAndStopLevels = tableValues.get(7);

        StockData stockData = new StockData(
                symbolWithDescription, mt5Symbol, spread, minMaxTradeSize,
                minMarginPercentage, longSwapValue, shortSwapValue, limitAndStopLevels
        );

        stockDataList.add(stockData);

        return stockDataList;
    }
}
