package ui.driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public final class DriverUtils {

    private DriverUtils() {
    }

    public static void setWindowSize(Dimension dimension) {
        WebDriver currentDriver = DriverManager.getDriver();
        currentDriver.manage().window().setSize(dimension);
    }
}
