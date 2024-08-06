package pages;

import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    public WebElement alertsMenu;
    @FindBy(xpath = "//h5[text()='Elements']")
    public WebElement elementsMenu;
    @FindBy(xpath = "//h5[text()='Forms']")
    public WebElement formMenu;

    public void navigateToAlertsMenu(){
        pageMethods.scrollPage(0,350);
        elementMethods.clickElement(alertsMenu);
        LoggerUtility.info("The user clicks on Alerts Menu");
    }

    public void navigateToFormsMenu(){
        pageMethods.scrollPage(0, 350);
        elementMethods.clickElement(formMenu);
        LoggerUtility.info("The user clicks on Forms Menu");
    }

    public void navigateToElementsMenu(){
        pageMethods.scrollPage(0, 350);
        elementMethods.clickElement(elementsMenu);
        LoggerUtility.info("The user clicks on Elements Menu");
    }

}
