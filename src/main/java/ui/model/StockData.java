package ui.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class StockData {
    private String symbolWithDescription;
    private String mt5Symbol;
    private String spread;
    private String minMaxTradeSize;
    private String minMarginPercentage;
    private String longSwapValue;
    private String shortSwapValue;
    private String limitAndStopLevels;

    // Конструктор
    public StockData(String symbolWithDescription, String mt5Symbol, String spread,
                     String minMaxTradeSize, String minMarginPercentage,
                     String longSwapValue, String shortSwapValue, String limitAndStopLevels) {
        this.symbolWithDescription = symbolWithDescription;
        this.mt5Symbol = mt5Symbol;
        this.spread = spread;
        this.minMaxTradeSize = minMaxTradeSize;
        this.minMarginPercentage = minMarginPercentage;
        this.longSwapValue = longSwapValue;
        this.shortSwapValue = shortSwapValue;
        this.limitAndStopLevels = limitAndStopLevels;
    }
}
