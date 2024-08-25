package pages;

import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import helperMethods.WindowMethods;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowsPage extends BasePage{

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    public WebElement newTab;
    @FindBy(id = "windowButton")
    public WebElement newWindow;

    public void interactWithNewTab(){
        elementMethods.clickElement(newTab);
        LoggerUtility.info("The user clicked on new tab button");
        System.out.println(driver.getCurrentUrl());
        windowMethods.switchSpecificTab(1);
        LoggerUtility.info("The user switched on second tab");
        System.out.println(driver.getCurrentUrl());
        LoggerUtility.info("The user closed the current tab");
        windowMethods.closeCurrentTab();
        windowMethods.switchSpecificTab(0);
        LoggerUtility.info("The user switched back on the default tab");
    }

    public void interactWithNewWindow(){
        elementMethods.clickJSElement(newWindow);
        LoggerUtility.info("The user performed a click");
        System.out.println(driver.getCurrentUrl());
        windowMethods.switchSpecificTab(1);
        LoggerUtility.info("The user switched to another tab");
        System.out.println(driver.getCurrentUrl());
        windowMethods.closeCurrentTab();
        LoggerUtility.info("The user closed the current tab");
        windowMethods.switchSpecificTab(0);
        System.out.println(driver.getCurrentUrl());
    }
}
