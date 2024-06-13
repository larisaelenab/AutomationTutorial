package tests;

import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableTest {

    public WebDriver driver;

    @Test
    public void metodaTest(){

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
        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        //elementsMenu.click();
        elementMethods.clickElement(elementsMenu);

        WebElement webTableSubmenu = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        //webTableSubmenu.click();
        elementMethods.clickElement(webTableSubmenu);

        //definim un element dupa id
        //Test1: adaug un entry
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        //addElement.click();
        elementMethods.clickElement(addElement);

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Larisa";
        //firstNameElement.sendKeys(firstNameValue);
        elementMethods.fillElement(firstNameElement, firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "B";
        //lastNameElement.sendKeys(lastNameValue);
        elementMethods.fillElement(lastNameElement, lastNameValue);

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailValue = "larisa@yahoo.com";
        //emailElement.sendKeys(emailValue);
        elementMethods.fillElement(emailElement, emailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "34";
        //ageElement.sendKeys(ageValue);
        elementMethods.fillElement(ageElement, ageValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "20000";
        //salaryElement.sendKeys(salaryValue);
        elementMethods.fillElement(salaryElement, salaryValue);

        WebElement departamentElement = driver.findElement(By.id("department"));
        String departamentValue = "Testing";
        //departamentElement.sendKeys(departamentValue);
        elementMethods.fillElement(departamentElement, departamentValue);

        WebElement submitElement = driver.findElement(By.id("submit"));
        //submitElement.click();
        elementMethods.clickElement(submitElement);


        //Test2: modific un entry existent
        WebElement updateElement = driver.findElement(By.id("edit-record-4"));
        //updateElement.click();
        elementMethods.clickElement(updateElement);

        WebElement editSalaryElement = driver.findElement(By.id("salary"));
        String editSalaryValue = "40000";
        //editSalaryElement.clear();
        //editSalaryElement.sendKeys(editSalaryValue);
        //elementMethods.fillElement(editSalaryElement, editSalaryValue);
        elementMethods.clearFillElement(editSalaryElement, editSalaryValue);

        WebElement editDepartamentElement = driver.findElement(By.id("department"));
        String editDepartamentValue = "Testing1";
        //editDepartamentElement.clear();
        //editDepartamentElement.sendKeys(editDepartamentValue);
        //elementMethods.fillElement(editDepartamentElement, editDepartamentValue);
        elementMethods.clearFillElement(editDepartamentElement, editDepartamentValue);

        WebElement editSubmitElement = driver.findElement(By.id("submit"));
        //editSubmitElement.click();
        elementMethods.clickElement(editSubmitElement);

        //Test3: sterg un entry existent
        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        //deleteElement.click();
        elementMethods.clickElement(deleteElement);

        driver.quit();







    }

}
