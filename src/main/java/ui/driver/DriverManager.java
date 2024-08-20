package ui.driver;

import core.config.Configuration;
import core.config.ConfigurationManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ui.resolution.Resolution;
import ui.resolution.ResolutionConstants;

import java.io.File;
import java.lang.reflect.Method;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final Configuration config = ConfigurationManager.config();

    private static Dimension dimension;

    public static void initializeDriver() {
        if (driver.get() == null) {
            WebDriver webDriver;
            String browser = config.browser().toLowerCase();

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (config.headless()) {
                        chromeOptions.addArguments("--headless");
                    }

                    // Remove Cookie reminder from flow
                    String noCookieExtensionPath = "src/test/resources/i-still-don-t-care-about-cookies-Chrome.crx";
                    File extensionFile = new File(noCookieExtensionPath);
                    chromeOptions.addExtensions(extensionFile);

                    webDriver = new ChromeDriver(chromeOptions);
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
            driver.set(webDriver);
        }
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            initializeDriver();
        }
        return driver.get();
    }

    public static void removeDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    public static void applyResolutionFromAnnotationOrMaximize(Method method) {
        WebDriver webDriver = driver.get();
        if (webDriver != null) {
            try {
                if (method.isAnnotationPresent(Resolution.class)) {
                    String resolutionName = method.getAnnotation(Resolution.class).value();
                    dimension = (Dimension) ResolutionConstants.class.getField(resolutionName).get(null);
                    webDriver.manage().window().setSize(dimension);
                } else {
                    webDriver.manage().window().maximize();
                    setResolutionAsMax();
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static Dimension getResolution() {
        return dimension;
    }

    public static void setResolutionAsMax() {
        dimension = new Dimension(-1, -1);
    }
}
