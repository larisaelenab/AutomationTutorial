package pages;

import objectData.PracticeFormObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;
import java.util.List;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    public WebElement firstNameElement;

    @FindBy(id = "lastName")
    public WebElement lastNameElement;

    @FindBy(id = "userEmail")
    public WebElement emailElement;

    @FindBy(xpath = "//div[@id='genterWrapper']/div/div/label[@class='custom-control-label']")
    public List<WebElement> genderElements;

    @FindBy(id = "userNumber")
    public WebElement mobileElement;

    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirthElement;

    @FindBy(className = "react-datepicker__month-select")
    public WebElement dateOfBirthMonthElement;

    @FindBy(className = "react-datepicker__year-select")
    public WebElement dateOfBirthYearElement;

    @FindBy(xpath = "//div[@class='react-datepicker__month']//div[not(contains(@class,'--outside-month')) and @role='option']")
    public List<WebElement> dateOfBirthDaysElements;

    @FindBy(id = "subjectsInput")
    public WebElement subjectElement;

    @FindBy(xpath = "//div[@id = 'hobbiesWrapper']/div/div/label[@class='custom-control-label']")
    public List<WebElement> hobbiesElements;

    @FindBy(id = "uploadPicture")
    public WebElement fileUploadElement;

    @FindBy(id = "currentAddress")
    public WebElement addressElement;

    @FindBy(id = "state")
    public WebElement stateElement;

    @FindBy(id = "react-select-3-input")
    public WebElement stateInputElement;

    @FindBy(id = "city")
    public WebElement cityElement;

    @FindBy(id = "react-select-4-input")
    public WebElement cityInputElement;

    @FindBy(id = "submit")
    public WebElement submitElement;

    @FindBy(id = "example-modal-sizes-title-lg")
    public WebElement thankYouMessageElement;

    @FindBy(xpath = "//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr")
    public List<WebElement> tableValues;

    @FindBy(id = "closeLargeModal")
    public WebElement closeButton;


    public void fillEntireForm(PracticeFormObject testData){

        elementMethods.fillElement(firstNameElement, testData.getFirstNameValue());


        elementMethods.fillElement(lastNameElement, testData.getLastNameValue());


        elementMethods.fillElement(emailElement, testData.getEmailValue());


        switch (testData.getGenderValue()) {
            case "Male":
                elementMethods.clickElement(genderElements.get(0));
                break;
            case "Female":
                elementMethods.clickElement(genderElements.get(1));
                break;
            case "Other":
                genderElements.get(2).click();
                elementMethods.clickElement(genderElements.get(2));
                break;
        }


        elementMethods.fillElement(mobileElement, testData.getUserNumberValue());

        elementMethods.clickElement(dateOfBirthElement);

        elementMethods.selectByTextElement(dateOfBirthMonthElement, "January");

        elementMethods.selectByValueElement(dateOfBirthYearElement,"1990");


        for (Integer index = 0; index < dateOfBirthDaysElements.size(); index++) {
            if (dateOfBirthDaysElements.get(index).getText().equals(testData.getChooseDayValue())) {
                elementMethods.clickElement(dateOfBirthDaysElements.get(index));
                break;
            }
        }


        elementMethods.fillElement(subjectElement, testData.getSubjectValue());
        elementMethods.pressElement(subjectElement, Keys.ENTER);


        pageMethods.scrollPage(0, 350);
        for (Integer index = 0; index < hobbiesElements.size(); index++) {
            String hobbyText = hobbiesElements.get(index).getText();
            if (testData.getActivitatiValue().contains(hobbyText)) {
                elementMethods.clickElement(hobbiesElements.get(index));
            }
        }


        File file = new File("src/test/resources/"+testData.getTerminatiePath());
        elementMethods.fillElement(fileUploadElement, file.getAbsolutePath());


        elementMethods.fillElement(addressElement, testData.getUserAddressValue());

        elementMethods.clickElement(stateElement);


        elementMethods.fillElement(stateInputElement, testData.getStateinputValue());
        elementMethods.pressElement(stateInputElement,Keys.ENTER);

        elementMethods.clickElement(cityElement);


        elementMethods.fillElement(cityInputElement, testData.getCityinputValue());
        elementMethods.pressElement(cityInputElement,Keys.ENTER);
        elementMethods.clickElement(submitElement);

    }


    public void validateEntireForm(PracticeFormObject testData){

        Assert.assertEquals(thankYouMessageElement.getText(), "Thanks for submitting the form");

        Assert.assertEquals(tableValues.get(0).getText(), "Student Name "+testData.getFirstNameValue()+" "+testData.getLastNameValue());
        Assert.assertEquals(tableValues.get(1).getText(), "Student Email "+testData.getEmailValue());
        Assert.assertEquals(tableValues.get(2).getText(), "Gender "+testData.getGenderValue());
        Assert.assertEquals(tableValues.get(3).getText(), "Mobile "+testData.getUserNumberValue());
        Assert.assertEquals(tableValues.get(4).getText(), "Date of Birth 15 January,1990");
        Assert.assertEquals(tableValues.get(5).getText(), "Subjects "+testData.getSubjectValue());
        String listStringHobbiesValues = String.join(", ", testData.getActivitatiValue());
        Assert.assertEquals(tableValues.get(6).getText(), "Hobbies "+listStringHobbiesValues);
        Assert.assertEquals(tableValues.get(7).getText(), "Picture "+testData.getTerminatiePath());
        Assert.assertEquals(tableValues.get(8).getText(), "Address "+testData.getUserAddressValue());
        Assert.assertEquals(tableValues.get(9).getText(), "State and City "+testData.getStateinputValue()+" "+testData.getCityinputValue());

        elementMethods.clickElement(closeButton);

        }


}
