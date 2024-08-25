package pages;

import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends BasePage{

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Web Tables']")
    public WebElement webTableSubmenu;

    public void selectWebTableSubmenu(){
        pageMethods.scrollPage(0, 350);
        LoggerUtility.info("The user scrolled down the page!");
        elementMethods.clickElement(webTableSubmenu);
        LoggerUtility.info("The user clicked on the Web Table submenu");
    }

}
