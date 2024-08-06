package pages;

import helperMethods.AlertMethods;
import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage extends BasePage{

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "alertButton")
    public WebElement firstAlert;
    @FindBy(id = "confirmButton")
    public WebElement confirmAlertButton;
    @FindBy(id = "promtButton")
    public WebElement promptAlertButton;
    @FindBy(id = "timerAlertButton")
    public WebElement timerAlertButton;



    public void interactAlertOk(){
        elementMethods.clickElement(firstAlert);
        LoggerUtility.info("The user clicks on the alertOK button");
        alertMethods.acceptAlert();
        LoggerUtility.info("The user interacts with the alertOK successfully");
    }

    public void interactWithConfirmationButton(){
        elementMethods.clickElement(confirmAlertButton);
        LoggerUtility.info("The user clicks on the confirmAlert button");
        alertMethods.dismissAlert();
        LoggerUtility.info("The user interacts with the confirmAlert successfully");
    }

    public void interactWithPromptButton(String text){
        elementMethods.clickElement(promptAlertButton);
        LoggerUtility.info("The user clicks on the prompt button");
        alertMethods.fillAlert(text);
        LoggerUtility.info("The user submits the text in the prompt");
    }

    public void interactWithTimerButton(){
        elementMethods.clickElement(timerAlertButton);
        LoggerUtility.info("The user clicks on the alertDelay button");
        alertMethods.acceptAlert();
        LoggerUtility.info("The user interacts with the alertDelay successfully");
    }

}
