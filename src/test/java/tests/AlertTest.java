package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.AlertsWindowsPage;
import pages.HomePage;
import sharedData.SharedData;

import java.time.Duration;

public class AlertTest extends SharedData {

    @Test
    public void alertTest(){

        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToAlertsMenu();
        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage(getDriver());
        alertsWindowsPage.navigateToAlertsPage();
        AlertsPage alertsPage = new AlertsPage(getDriver());
        alertsPage.interactAlertOk();
        alertsPage.interactWithTimerButton();
        alertsPage.interactWithPromptButton("text alerta");
        alertsPage.interactWithConfirmationButton();

    }
}
