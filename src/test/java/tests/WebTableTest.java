package tests;

import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;
import sharedData.SharedData;

public class WebTableTest extends SharedData {

    @Test
    public void metodaTest(){

        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToElementsMenu();

        ElementsPage elementsPage = new ElementsPage(getDriver());
        elementsPage.selectWebTableSubmenu();

        WebTablePage webTablePage = new WebTablePage(getDriver());
        webTablePage.addEntry("Larisa", "B", "larisa@yahoo.com", "34",
                "8555", "Testing");
        webTablePage.editEntry("10000", "HR");
        webTablePage.deleteEntry();

    }
}
