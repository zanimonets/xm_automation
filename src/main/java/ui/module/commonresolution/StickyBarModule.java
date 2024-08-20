package ui.module.commonresolution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.constants.JSCommands;
import ui.module.base.BaseModule;
import ui.util.JSExecutor;

import java.time.Duration;

public class StickyBarModule extends BaseModule {

    public StickyBarModule(WebDriver driver) {
        super(driver);
    }

    public void waitPresenceAndRemoveModule() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement rootElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'sticky-bar')]")));
        JSExecutor.executeScriptOnElement(JSCommands.REMOVE_ELEMENT_FROM_PAGE, rootElement);
    }
}
