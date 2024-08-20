package ui.tests;

import core.Logger;
import core.config.Configuration;
import core.config.ConfigurationManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ui.driver.DriverManager;

import java.lang.reflect.Method;

public class BaseTest {
    protected WebDriver driver;
    protected Configuration config;


    @BeforeMethod()
    protected void setUp(Method method) {
        Logger.info("Init config, driver");


        config = ConfigurationManager.config();

        DriverManager.initializeDriver();
        DriverManager.applyResolutionFromAnnotationOrMaximize(method);

        driver = DriverManager.getDriver();
        driver.get(config.baseUrl());
    }

    @AfterMethod()
    protected void tearDown() {
        DriverManager.removeDriver();
        Logger.info("Driver quit");
    }
}
