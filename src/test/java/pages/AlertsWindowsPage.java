package pages;

import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsWindowsPage extends BasePage{

    public AlertsWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Browser Windows']")
    public WebElement browserWindowsSubmenu;
    @FindBy(xpath = "//span[text()='Frames']")
    public WebElement framesFromSubmenu;
    @FindBy(xpath = "//span[text()='Alerts']")
    public WebElement alertsFromSubmenu;


    public void navigateToWindowPage(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(browserWindowsSubmenu);
        LoggerUtility.info("The user clicks on Form submenu");
    }

    public void navigateToFramePage(){
        pageMethods.scrollPage(0, 350);
        elementMethods.clickElement(framesFromSubmenu);
        LoggerUtility.info("The user clicks on Frame page");

    }

    public void navigateToAlertsPage(){
        elementMethods.clickElement(alertsFromSubmenu);
        LoggerUtility.info("The user clicks on alerts form");
    }

}
