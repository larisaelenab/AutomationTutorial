package tests;

import helperMethods.AlertMethods;
import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import io.opentelemetry.semconv.SemanticAttributes;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.AlertsWindowsPage;
import pages.HomePage;

import java.time.Duration;

public class AlertTest {
    public WebDriver driver;

    @Test
    public void alertTest(){
        driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();

        //wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //definim un obiect de tip alert methods ca sa apelam metodele generale din clasa
        AlertMethods alertMethods = new AlertMethods(driver);
        ElementMethods elementMethods = new ElementMethods(driver);
        PageMethods pageMethods = new PageMethods(driver);
        HomePage homePage = new HomePage(driver);
        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage(driver);
        AlertsPage alertsPage = new AlertsPage(driver);

        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,350)", "");
        //pageMethods.scrollPage(0,350);
        //WebElement alertsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        //alertsMenu.click();
        //elementMethods.clickElement(alertsMenu);

        homePage.navigateToAlertsMenu();
        alertsWindowsPage.navigateToAlertsPage();
        alertsPage.interactAlertOk();
        alertsPage.interactWithTimerButton();
        alertsPage.interactWithPromptButton("text alerta");
        alertsPage.interactWithConfirmationButton();



        //WebElement alertsFromSubmenu = driver.findElement(By.xpath("//span[text()='Alerts']"));
        //alertsFromSubmenu.click();
        //elementMethods.clickElement(alertsFromSubmenu);

        //interactionam cu o alerta
        //WebElement firstAlert = driver.findElement(By.id("alertButton"));
        //firstAlert.click();
        //elementMethods.clickElement(firstAlert);
        //alertMethods.acceptAlert();
        //Alert alertOk = driver.switchTo().alert();
        //System.out.println(alertOk.getText());
        //alertOk.accept();

        //WebElement confirmAlertButton = driver.findElement(By.id("confirmButton"));
        //confirmAlertButton.click();
        //elementMethods.clickElement(confirmAlertButton);
        //alertMethods.dismissAlert();
        //Alert confirmAlert = driver.switchTo().alert();
        //System.out.println(confirmAlert.getText());
        //confirmAlert.dismiss();

        ///WebElement promptAlertButton = driver.findElement(By.id("promtButton"));
        //promptAlertButton.click();
        //elementMethods.clickElement(promptAlertButton);
        //alertMethods.fillAlert("text alerta");
        //Alert promptAlert = driver.switchTo().alert();
        //System.out.println(promptAlert.getText());
        //String alertValue = "text alerta";
        //promptAlert.sendKeys(alertValue);
        //promptAlert.accept();


        //interactionam cu o alerta pt care trebuie sa asteptam putin
        //WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
        //timerAlertButton.click();
        //elementMethods.clickElement(timerAlertButton);
        //alertMethods.acceptAlert();
        //definim un wait explicit
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.alertIsPresent());
        //Alert timerAlert = driver.switchTo().alert();
        //System.out.println(timerAlert.getText());
        //timerAlert.accept();





    }
}
