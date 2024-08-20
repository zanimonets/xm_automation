package ui.util;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.driver.DriverManager;

import java.time.Duration;
import java.util.function.Function;

public class ElementUtils {
    private static final long ACTION_TIMEOUT_SEC = 35;
    private static final long POLLING_TIMEOUT_MILLIS = 500;

    private ElementUtils() {
    }

    private static final WebDriverWait wait;
    private static final FluentWait fluentWait;

    static {
        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ACTION_TIMEOUT_SEC), Duration.ofMillis(POLLING_TIMEOUT_MILLIS));
        fluentWait = new FluentWait<>(DriverManager.getDriver()).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class);

    }

    public static void waitUntilElementBecomeActive(WebElement webElement){
        try {
            wait.until(ExpectedConditions.attributeContains(webElement, "class", "active"));
        } catch (TimeoutException e) {
            throw new TimeoutException("Element did not become active within " + ACTION_TIMEOUT_SEC + " seconds", e);
        }
    }

    public static void waitUntilVisible(WebElement webElement) {
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (TimeoutException e) {
            throw new TimeoutException("Element did not become visible within " + ACTION_TIMEOUT_SEC + " seconds", e);
        }
    }

    public static void waitUntilInvisible(WebElement webElement){
        try {
            wait.until(ExpectedConditions.invisibilityOf(webElement));
        } catch (TimeoutException e) {
            throw new TimeoutException("Element did not become invisible within " + ACTION_TIMEOUT_SEC + " seconds", e);
        }
    }

    public static void waitUntilClickable(WebElement webElement) {
        try {
            fluentWait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    if (webElement.isDisplayed() && webElement.isEnabled()) {
                        return webElement;
                    }
                    return null;
                }
            });
        } catch (Exception e) {
            throw new RuntimeException("Element did not become clickable within " + ACTION_TIMEOUT_SEC + " seconds", e);
        }
    }
}
