package ui.tests.helper;
import org.testng.asserts.SoftAssert;
import ui.model.StockData;
import ui.model.TradingConditions;

public class StockDataAndTradingConditionsComparator {

    public static void compare(SoftAssert softAssert, StockData stockData, TradingConditions tradingConditions) {
        softAssert.assertTrue(
                stockData.getSymbolWithDescription().contains(tradingConditions.getDescription()),
                "Description mismatch: StockData.symbolWithDescription contains " + stockData.getSymbolWithDescription() +
                        ", TradingConditions.description is " + tradingConditions.getDescription());

        softAssert.assertEquals(
                stockData.getMt5Symbol(),
                tradingConditions.getSymbols(),
                "Symbols mismatch: StockData.mt5Symbol is " + stockData.getMt5Symbol() +
                        ", TradingConditions.symbols is " + tradingConditions.getSymbols());

        softAssert.assertEquals(
                stockData.getSpread(),
                tradingConditions.getSpreadAsLowAs(),
                "Spread mismatch: StockData.spread is " + stockData.getSpread() +
                        ", TradingConditions.spreadAsLowAs is " + tradingConditions.getSpreadAsLowAs());

        softAssert.assertEquals(
                stockData.getMinMaxTradeSize(),
                tradingConditions.getMinMaxTradeSize(),
                "MinMaxTradeSize mismatch: StockData.minMaxTradeSize is " + stockData.getMinMaxTradeSize() +
                        ", TradingConditions.minMaxTradeSize is " + tradingConditions.getMinMaxTradeSize());

        softAssert.assertEquals(
                stockData.getMinMarginPercentage(),
                tradingConditions.getMinMarginPercentage(),
                "MinMarginPercentage mismatch: StockData.minMarginPercentage is " + stockData.getMinMarginPercentage() +
                        ", TradingConditions.minMarginPercentage is " + tradingConditions.getMinMarginPercentage());

        softAssert.assertEquals(
                stockData.getLongSwapValue(),
                tradingConditions.getSwapValueLong(),
                "LongSwapValue mismatch: StockData.longSwapValue is " + stockData.getLongSwapValue() +
                        ", TradingConditions.swapValueLong is " + tradingConditions.getSwapValueLong());

        softAssert.assertEquals(
                stockData.getShortSwapValue(),
                tradingConditions.getSwapValueShort(),
                "ShortSwapValue mismatch: StockData.shortSwapValue is " + stockData.getShortSwapValue() +
                        ", TradingConditions.swapValueShort is " + tradingConditions.getSwapValueShort());

        softAssert.assertEquals(
                stockData.getLimitAndStopLevels(),
                tradingConditions.getLimitAndStopLevels(),
                "LimitAndStopLevels mismatch: StockData.limitAndStopLevels is " + stockData.getLimitAndStopLevels() +
                        ", TradingConditions.limitAndStopLevels is " + tradingConditions.getLimitAndStopLevels());
    }
}
