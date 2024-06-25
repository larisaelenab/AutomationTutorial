package pages;

import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsWindowsPage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public PageMethods pageMethods;

    public AlertsWindowsPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        pageMethods = new PageMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Browser Windows']")
    public WebElement browserWindowsSubmenu;

    public void navigateToWindowPage(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(browserWindowsSubmenu);
    }

    @FindBy(xpath = "//span[text()='Frames']")
    public WebElement framesFromSubmenu;

    public void navigateToFramePage(){
        pageMethods.scrollPage(0, 350);
        elementMethods.clickElement(framesFromSubmenu);

    }


}
