package pages;

import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import helperMethods.WindowMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowsPage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    public WindowMethods windowMethods;

    public WindowsPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        pageMethods = new PageMethods(driver);
        windowMethods = new WindowMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "tabButton")
    public WebElement newTab;

    @FindBy(id = "windowButton")
    public WebElement newWindow;

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
