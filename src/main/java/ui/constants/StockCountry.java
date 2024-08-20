package ui.constants;

public enum StockCountry {
    ALL_STOCKS("All Stocks"),
    SPAIN("Spain"),
    USA("USA"),
    FRANCE("France"),
    UK("UK"),
    NETHERLANDS("Netherlands"),
    ITALY("Italy"),
    GERMANY("Germany"),
    SWEDEN("Sweden"),
    BELGIUM("Belgium"),
    FINLAND("Finland"),
    NORWAY("Norway"),
    SWITZERLAND("Switzerland"),
    PORTUGAL("Portugal"),
    AUSTRIA("Austria"),
    BRAZIL("Brazil"),
    GREECE("Greece"),
    CANADA("Canada");

    private final String displayName;

    StockCountry(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
