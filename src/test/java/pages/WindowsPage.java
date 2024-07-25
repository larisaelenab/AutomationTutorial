package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsPage extends BasePage{

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    private WebElement newTab;
    @FindBy(id = "windowButton")
    private WebElement newWindow;

    public void interactWithNewTab(){
        elementMethods.clickElement(newTab);
        System.out.println(driver.getCurrentUrl());
        windowMethods.switchSpecificTab(1);
        System.out.println(driver.getCurrentUrl());
        windowMethods.closeCurrentTab();
        windowMethods.switchSpecificTab(0);
    }

    public void interactWithNewWindow(){
        elementMethods.clickElement(newWindow);
        System.out.println(driver.getCurrentUrl());
        windowMethods.switchSpecificTab(1);
        System.out.println(driver.getCurrentUrl());
        windowMethods.closeCurrentTab();
        windowMethods.switchSpecificTab(0);
        System.out.println(driver.getCurrentUrl());
    }
}
