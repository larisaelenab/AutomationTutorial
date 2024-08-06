package pages;

import loggerUtility.LoggerUtility;
import objectData.WebTableObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebTablePage extends BasePage{

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "addNewRecordButton")
    public WebElement addElement;
    @FindBy(id = "firstName")
    public WebElement firstNameElement;
    @FindBy(id = "lastName")
    public WebElement lastNameElement;
    @FindBy(id = "userEmail")
    public WebElement emailElement;
    @FindBy(id = "age")
    public WebElement ageElement;
    @FindBy(id = "salary")
    public WebElement salaryElement;
    @FindBy(id = "department")
    public WebElement departamentElement;
    @FindBy(id = "submit")
    public WebElement submitElement;
    @FindBy(id = "edit-record-4")
    public WebElement updateElement;
    @FindBy(id = "salary")
    public WebElement editSalaryElement;
    @FindBy(id = "department")
    public WebElement editDepartamentElement;
    @FindBy(id = "submit")
    public WebElement editSubmitElement;
    @FindBy(id = "delete-record-4")
    public WebElement deleteElement;



    public void addEntry(WebTableObject testData){
        elementMethods.clickElement(addElement);
        LoggerUtility.info("The user clicked to add a new entry");
        elementMethods.fillElement(firstNameElement, testData.getFirstNameValue());
        LoggerUtility.info("The user fills firstname element with the value: " + testData.getFirstNameValue());
        elementMethods.fillElement(lastNameElement, testData.getLastNameValue());
        LoggerUtility.info("The user fills in the lastname element with the value: " + testData.getLastNameValue());
        elementMethods.fillElement(emailElement, testData.getEmailValue());
        LoggerUtility.info("The user fills in the useremailelement with the value: " + testData.getEmailValue());
        elementMethods.fillElement(ageElement, testData.getAgeValue());
        LoggerUtility.info("The user fills in the ageelement with the value: " + testData.getAgeValue());
        elementMethods.fillElement(salaryElement, testData.getSalaryValue());
        LoggerUtility.info("The user fills in the salaryelement with the value: " + testData.getSalaryValue());
        elementMethods.fillElement(departamentElement, testData.getDepartmentValue());
        LoggerUtility.info("The user fills in the departmentelement with the value: " + testData.getDepartmentValue());
        elementMethods.clickElement(submitElement);
        LoggerUtility.info("The user clicked to submit the form");
    }

    public void editEntry(WebTableObject testData){
        elementMethods.clickElement(updateElement);
        LoggerUtility.info("The user clicked to edit an existing entry");
        elementMethods.clearFillElement(editSalaryElement, testData.getEditsalaryValue());
        LoggerUtility.info("The user edits firstname element with the value: " + testData.getEditsalaryValue());
        elementMethods.clearFillElement(editDepartamentElement, testData.getEditdepartmentValue());
        LoggerUtility.info("The user edits the salaryelement  with the value: " + testData.getEditdepartmentValue());
        elementMethods.clickElement(editSubmitElement);
        LoggerUtility.info("The user clicked to submit the edited values");
    }

    public void deleteEntry(){
        elementMethods.clickElement(deleteElement);
        LoggerUtility.info("The user clicked to delete the entry");
    }



}
