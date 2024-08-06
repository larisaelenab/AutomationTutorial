package pages;

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
        elementMethods.fillElement(firstNameElement, testData.getFirstNameValue());
        elementMethods.fillElement(lastNameElement, testData.getLastNameValue());
        elementMethods.fillElement(emailElement, testData.getEmailValue());
        elementMethods.fillElement(ageElement, testData.getAgeValue());
        elementMethods.fillElement(salaryElement, testData.getSalaryValue());
        elementMethods.fillElement(departamentElement, testData.getDepartmentValue());
        elementMethods.clickElement(submitElement);
    }

    public void editEntry(WebTableObject testData){
        elementMethods.clickElement(updateElement);
        elementMethods.clearFillElement(editSalaryElement, testData.getEditsalaryValue());
        elementMethods.clearFillElement(editDepartamentElement, testData.getEditdepartmentValue());
        elementMethods.clickElement(editSubmitElement);
    }

    public void deleteEntry(){
        elementMethods.clickElement(deleteElement);
    }



}
