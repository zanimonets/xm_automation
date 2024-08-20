package ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ui.constants.StockCountry;
import ui.model.StockData;
import ui.model.TradingConditions;
import ui.page.commonresolution.CompanyProfilePage;
import ui.page.commonresolution.HomePage;
import ui.page.commonresolution.StocksPage;
import ui.page.svgaresolution.HomeSVGAPage;
import ui.resolution.Resolution;
import ui.tests.helper.StockDataAndTradingConditionsComparator;

import java.util.List;

public class CompanyStockDataTest extends BaseTest{
    private HomePage homePage;

    private StocksPage stocksPage;
    private CompanyProfilePage companyProfilePage;

    String testCompany = "Orkla ASA (ORK.OL)";

    @BeforeMethod(alwaysRun = true)
    public void setupTest() {
        homePage = new HomePage(driver);
        stocksPage = new StocksPage(driver);
        companyProfilePage = new CompanyProfilePage(driver);
    }

    @Test
    public void CompanyStockDataMAXResTest() {
        homePage.topMenuModule().clickTradingOption();
        homePage.tradingDropDownModule().clickStocksOption();

        stocksPage.stocksCFDsTabModule().chooseCountry(StockCountry.NORWAY);
        stocksPage.stocksCFDsTabModule().performSearch(testCompany);
        List<StockData> stockData = stocksPage.stocksCFDsTabModule().stocksTableModule().parseTable();
        stocksPage.stocksCFDsTabModule().stocksTableModule().clickReadMoreBtnByCompany(testCompany);

        TradingConditions tradingConditionsCombinedTable = companyProfilePage.tradingConditionsModule().getTradingConditionsCombinedTable();
        SoftAssert softAssert = new SoftAssert();
        StockDataAndTradingConditionsComparator.compare(softAssert,stockData.get(0), tradingConditionsCombinedTable);
        softAssert.assertAll();
    }

    @Test
    @Resolution("XGA")
    public void CompanyStockDataXGAResTest() {
        homePage.topMenuModule().clickTradingOption();

        homePage.tradingDropDownModule().clickStocksOption();

        stocksPage.stocksCFDsTabModule().chooseCountry(StockCountry.NORWAY);
        stocksPage.stocksCFDsTabModule().performSearch(testCompany);
        List<StockData> stockData = stocksPage.stocksCFDsTabModule().stocksTableModule().parseTable();
        stocksPage.stocksCFDsTabModule().stocksTableModule().clickReadMoreBtnByCompany(testCompany);

        TradingConditions tradingConditionsCombinedTable = companyProfilePage.tradingConditionsModule().getTradingConditionsCombinedTable();
        SoftAssert softAssert = new SoftAssert();
        StockDataAndTradingConditionsComparator.compare(softAssert,stockData.get(0), tradingConditionsCombinedTable);
        softAssert.assertAll();
    }

    @Test
    @Resolution("SVGA")
    public void CompanyStockDataSVGAResTest() {
        HomeSVGAPage homeSVGAPage = new HomeSVGAPage(driver);

        homeSVGAPage.topMenuSVGAModule().clickThreeLineMenuIcon();
        homeSVGAPage.leftNavigationBarSVGAModule().clickTradingMenuOption();
        homeSVGAPage.leftNavigationBarSVGAModule().tradingNavigationBarListSVGAModule().clickStocksOption();

        stocksPage.stocksCFDsTabModule().chooseCountry(StockCountry.NORWAY);
        stocksPage.stocksCFDsTabModule().performSearch(testCompany);

        stocksPage.stocksCFDsTabModule().stocksTableModule().scrollAndExpandRow(testCompany);
        List<StockData> stockData = stocksPage.stocksCFDsTabModule().stocksTableModule().parseTable();
        stocksPage.stocksCFDsTabModule().stocksTableModule().clickReadMoreBtnByCompany(testCompany);

        TradingConditions tradingConditionsCombinedTable = companyProfilePage.tradingConditionsModule().getTradingConditionsCombinedTable();
        SoftAssert softAssert = new SoftAssert();
        StockDataAndTradingConditionsComparator.compare(softAssert,stockData.get(0), tradingConditionsCombinedTable);
        softAssert.assertAll();
    }
}
