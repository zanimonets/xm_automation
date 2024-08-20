package ui.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import ui.constants.JSCommands;
import ui.driver.DriverManager;

public class JSExecutor {
    private static final JavascriptExecutor js = (JavascriptExecutor)DriverManager.getDriver();

    private JSExecutor() {
    }

    public static Object executeScriptOnElement(JSCommands command, WebElement element) {
        return js.executeScript(command.getCommandString(), element);
    }

    public static void executeScript(String command, Object... params) {
        js.executeScript(command, params);
    }
}
