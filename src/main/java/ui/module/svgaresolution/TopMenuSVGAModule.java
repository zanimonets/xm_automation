package ui.module.svgaresolution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.module.base.BaseModule;

public class TopMenuSVGAModule extends BaseModule {

    @FindBy(xpath = "//button[@class='toggleLeftNav']/i")
    private WebElement threeLineMenuIcon;

    public TopMenuSVGAModule(WebDriver driver) {
        super(driver);
    }

    public void clickThreeLineMenuIcon() {
        threeLineMenuIcon.click();
    }
}
