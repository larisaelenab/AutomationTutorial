package tests;

import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;
import sharedData.SharedData;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest() {

        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToFormsMenu();
        FormsPage formsPage = new FormsPage(getDriver());
        formsPage.navigateToPracticeForm();
        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        String firstNameValue = "Larisa";
        String lastNameValue = "Buleu";
        String emailValue = "larisa@yahoo.com";
        String genderValue = "Female";
        String mobileValue = "0766000000";
        String dateofBirthDayValue = "15";
        String subjectValue = "Accounting";
        List<String> hobbiesValues = Arrays.asList("Reading", "Music");
        String picturePathValue = "test.txt";
        String addressValue = "Str. Mihai-Bravu, nr 12";
        String stateInputValue = "Haryana";
        String cityInputValue = "Panipat";

        practiceFormPage.fillEntireForm(firstNameValue, lastNameValue, emailValue, genderValue, mobileValue, dateofBirthDayValue, subjectValue, hobbiesValues,
                picturePathValue, addressValue, stateInputValue, cityInputValue);
        practiceFormPage.validateEntireForm(firstNameValue, lastNameValue, emailValue, genderValue, mobileValue, dateofBirthDayValue, subjectValue, hobbiesValues, picturePathValue,
                addressValue, stateInputValue, cityInputValue);

    }
}
