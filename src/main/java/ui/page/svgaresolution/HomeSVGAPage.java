package ui.page.svgaresolution;

import org.openqa.selenium.WebDriver;
import ui.module.svgaresolution.LeftNavigationBarSVGAModule;
import ui.page.base.BasePage;
import ui.module.svgaresolution.TopMenuSVGAModule;

public class HomeSVGAPage extends BasePage {

    private TopMenuSVGAModule topMenuSVGAModule;
    private LeftNavigationBarSVGAModule leftNavigationBarSVGAModule;

    public HomeSVGAPage(WebDriver driver) {
        super(driver);
        this.topMenuSVGAModule = new TopMenuSVGAModule(driver);
        this.leftNavigationBarSVGAModule = new LeftNavigationBarSVGAModule(driver);
    }

    public TopMenuSVGAModule topMenuSVGAModule() {
        return topMenuSVGAModule;
    }

    public LeftNavigationBarSVGAModule leftNavigationBarSVGAModule() {
        return leftNavigationBarSVGAModule;
    }


}
