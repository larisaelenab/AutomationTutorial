package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;

public class WebTableTest {

    public WebDriver driver;

    @Test
    public void metodaTest(){

        driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);
        homePage.navigateToElementsMenu();

        ElementsPage elementsPage = new ElementsPage(driver);
        elementsPage.selectWebTableSubmenu();

        WebTablePage webTablePage = new WebTablePage(driver);
        webTablePage.addEntry("Larisa", "B", "larisa@yahoo.com", "34",
                "8555", "Testing");
        webTablePage.editEntry("10000", "HR");
        webTablePage.deleteEntry();

        driver.quit();

    }

}
