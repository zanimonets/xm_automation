package ui.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class TradingConditions {
    private String minMarginPercentage;
    private String symbols;
    private String description;
    private String minPriceFluctuation;
    private String valueOfMinPriceFluctuation;
    private String valueOfLot;
    private String spreadAsLowAs;
    private String minMaxTradeSize;
    private String swapValueLong;
    private String swapValueShort;
    private String limitAndStopLevels;
    private String totalVolumeLimit;
}
