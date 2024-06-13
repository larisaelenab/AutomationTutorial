package tests;

import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import helperMethods.WindowMethods;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest {
    public WebDriver driver;

    @Test
    public void metodaTest() {

        //deschidem un browser
        driver = new ChromeDriver();

        //accesam un anumit url
        driver.get("https://demoqa.com");

        //facem browserul in modul maximize
        driver.manage().window().maximize();

        //Obiecte
        ElementMethods elementMethods = new ElementMethods(driver);
        PageMethods pageMethods = new PageMethods(driver);

        //facem un scroll la pagina pt vizibilitate
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,350)", "");
        pageMethods.scrollPage(0, 350);

        //interactionam cu meniul/ submeniul de pe site
        WebElement formMenu = driver.findElement(By.xpath("//h5[text()='Forms']"));
        //formMenu.click();
        elementMethods.clickElement(formMenu);

        WebElement practiceFromSubmenu = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        //practiceFromSubmenu.click();
        elementMethods.clickElement(practiceFromSubmenu);

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Larisa";
        //firstNameElement.sendKeys(firstNameValue);
        elementMethods.fillElement(firstNameElement, firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Buleu";
        //lastNameElement.sendKeys(lastNameValue);
        elementMethods.fillElement(lastNameElement, lastNameValue);

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailValue = "larisa@yahoo.com";
        //emailElement.sendKeys(emailValue);
        elementMethods.fillElement(emailElement, emailValue);

        //definim o logica generala de a selecta un element dintr-o lista
        List<WebElement> genderElements = driver.findElements(By.xpath("//div[@id='genterWrapper']/div/div/label[@class='custom-control-label']"));
        String genderValue = "Female";
        switch (genderValue) {
            case "Male":
                //genderElements.get(0).click();
                elementMethods.clickElement(genderElements.get(0));
                break;
            case "Female":
                //genderElements.get(1).click();
                elementMethods.clickElement(genderElements.get(1));
                break;
            case "Other":
                genderElements.get(2).click();
                elementMethods.clickElement(genderElements.get(2));
                break;
        }

        WebElement mobileElement = driver.findElement(By.id("userNumber"));
        String mobileValue = "0766000000";
        //mobileElement.sendKeys(mobileValue);
        elementMethods.fillElement(mobileElement, mobileValue);

        //date of birth
        WebElement dateOfBirthElement = driver.findElement(By.id("dateOfBirthInput"));
        //dateOfBirthElement.click();
        elementMethods.clickElement(dateOfBirthElement);

        WebElement dateOfBirthMonthElement = driver.findElement(By.className("react-datepicker__month-select"));
        //Select monthSelect = new Select(dateOfBirthMonthElement);
        //monthSelect.selectByVisibleText("January");
        elementMethods.selectByTextElement(dateOfBirthMonthElement, "January");

        WebElement dateOfBirthYearElement = driver.findElement(By.className("react-datepicker__year-select"));
        //Select yearSelect = new Select(dateOfBirthYearElement);
        //yearSelect.selectByValue("1990");
        elementMethods.selectByValueElement(dateOfBirthYearElement,"1990");

        List<WebElement> dateOfBirthDaysElements = driver.findElements(By.xpath("//div[@class='react-datepicker__month']//div[not(contains(@class,'--outside-month')) and @role='option']"));
        String dateofBirthDayValue = "15";
        for (Integer index = 0; index < dateOfBirthDaysElements.size(); index++) {
            if (dateOfBirthDaysElements.get(index).getText().equals(dateofBirthDayValue)) {
                //dateOfBirthDaysElements.get(index).click();
                elementMethods.clickElement(dateOfBirthDaysElements.get(index));
                break;
            }
        }


        WebElement subjectElement = driver.findElement(By.id("subjectsInput"));
        String subjectValue = "Accounting";
        //subjectElement.sendKeys(subjectValue);
        elementMethods.fillElement(subjectElement, subjectValue);
        //subjectElement.sendKeys(Keys.ENTER);
        elementMethods.pressElement(subjectElement,Keys.ENTER);

        List<WebElement> hobbiesElements = driver.findElements(By.xpath("//div[@id = 'hobbiesWrapper']/div/div/label[@class='custom-control-label']"));
        List<String> hobbiesValues = Arrays.asList("Reading", "Music");
        //JavascriptExecutor js1 = (JavascriptExecutor) driver;
        //js1.executeScript("window.scrollBy(0,350)", "");
        pageMethods.scrollPage(0, 350);
        for (Integer index = 0; index < hobbiesElements.size(); index++) {
            String hobbyText = hobbiesElements.get(index).getText();
            if (hobbiesValues.contains(hobbyText)) {
                //hobbiesElements.get(index).click();
                elementMethods.clickElement(hobbiesElements.get(index));
            }
        }


        //interactionam cu un fisier
        WebElement fileUploadElement = driver.findElement(By.id("uploadPicture"));
        String picturePathValue = "test.txt";
        File file = new File("src/test/resources/"+picturePathValue);
        //fileUploadElement.sendKeys(file.getAbsolutePath());
        elementMethods.fillElement(fileUploadElement, file.getAbsolutePath());


        WebElement addressElement = driver.findElement(By.id("currentAddress"));
        String addressValue = "Str. Mihai-Bravu, nr 12";
        //addressElement.sendKeys(addressValue);
        elementMethods.fillElement(addressElement, addressValue);

        WebElement stateElement = driver.findElement(By.id("state"));
        //stateElement.click();
        elementMethods.clickElement(stateElement);

        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateInputValue = "Haryana";
        //stateInputElement.sendKeys(stateInputValue);
        //stateInputElement.sendKeys(Keys.ENTER);
        elementMethods.fillElement(stateInputElement, stateInputValue);
        elementMethods.pressElement(stateInputElement,Keys.ENTER);

        WebElement cityElement = driver.findElement(By.id("city"));
        //cityElement.click();
        elementMethods.clickElement(cityElement);

        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String cityInputValue = "Panipat";
        //cityInputElement.sendKeys(cityInputValue);
        //cityInputElement.sendKeys(Keys.ENTER);
        elementMethods.fillElement(cityInputElement, cityInputValue);
        elementMethods.pressElement(cityInputElement,Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        //submitElement.click();
        elementMethods.clickElement(submitElement);

        //validam tabelul cu valorile introduse
        WebElement thankYouMessageElement = driver.findElement(By.id("example-modal-sizes-title-lg"));
        Assert.assertEquals(thankYouMessageElement.getText(), "Thanks for submitting the form");

        List<WebElement> tableValues = driver.findElements(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr"));
        Assert.assertEquals(tableValues.get(0).getText(), "Student Name "+firstNameValue+" "+lastNameValue);
        Assert.assertEquals(tableValues.get(1).getText(), "Student Email "+emailValue);
        Assert.assertEquals(tableValues.get(2).getText(), "Gender "+genderValue);
        Assert.assertEquals(tableValues.get(3).getText(), "Mobile "+mobileValue);
        Assert.assertEquals(tableValues.get(4).getText(), "Date of Birth 15 January,1990");
        Assert.assertEquals(tableValues.get(5).getText(), "Subjects "+subjectValue);
        String listStringHobbiesValues = String.join(", ", hobbiesValues);
        Assert.assertEquals(tableValues.get(6).getText(), "Hobbies "+listStringHobbiesValues);
        Assert.assertEquals(tableValues.get(7).getText(), "Picture "+picturePathValue);
        Assert.assertEquals(tableValues.get(8).getText(), "Address "+addressValue);
        Assert.assertEquals(tableValues.get(9).getText(), "State and City "+stateInputValue+" "+cityInputValue);

        WebElement closeButton = driver.findElement(By.id("closeLargeModal"));
        //js.executeScript("arguments[0].click();", closeButton);
        //closeButton.click();
        elementMethods.clickElement(closeButton);


    }

}
