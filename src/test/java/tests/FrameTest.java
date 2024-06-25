package tests;

import helperMethods.AlertMethods;
import helperMethods.ElementMethods;
import helperMethods.FrameMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.AlertsWindowsPage;
import pages.FramePage;
import pages.HomePage;
import pages.NestedFramePage;

import java.time.Duration;

public class FrameTest {

    public WebDriver driver;

    @Test
    public void alertTest() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();

        //wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //definim un obiect de tip alert methods ca sa apelam metodele generale din clasa
        ElementMethods elementMethods = new ElementMethods(driver);
        PageMethods pageMethods = new PageMethods(driver);
        FrameMethods frameMethods = new FrameMethods(driver);

        HomePage homePage = new HomePage(driver);
        homePage.navigateToAlertsMenu();

        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage(driver);
        alertsWindowsPage.navigateToFramePage();

        FramePage framePage = new FramePage(driver);
        framePage.interactWithBigIFrame();
        framePage.interactWithSmallIFrame();
        framePage.navigateToNestedFrames();

        NestedFramePage nestedFramePage = new NestedFramePage(driver);
        nestedFramePage.interactWithNestedFrames();


        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,350)", "");
        //pageMethods.scrollPage(0, 350);
        //WebElement alertsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        //alertsMenu.click();
        //elementMethods.clickElement(alertsMenu);

        //WebElement framesFromSubmenu = driver.findElement(By.xpath("//span[text()='Frames']"));
        //alertsFromSubmenu.click();
        //elementMethods.clickElement(framesFromSubmenu);

        //ne mutam cu focusul pe Iframe
        //driver.switchTo().frame("frame1");
        //frameMethods.switchToFrame("frame1");
        //WebElement iframeText = driver.findElement(By.id("sampleHeading"));
        //System.out.println(iframeText.getText());

        //ne intoarcem cu focusul la frame-ul default
        //driver.switchTo().defaultContent();

        //driver.switchTo().frame("frame2");
        //frameMethods.switchToFrame("frame2");
        //WebElement iframeText2 = driver.findElement(By.id("sampleHeading"));
        //System.out.println(iframeText2.getText());

        //driver.switchTo().defaultContent();
        //frameMethods.switchToDefault();

        //WebElement nestedFramesFromSubmenu = driver.findElement(By.xpath("//span[text()='Nested Frames']"));
        //alertsFromSubmenu.click();
        //elementMethods.clickElement(nestedFramesFromSubmenu);

        //interactionam cu iframe in iframe
        //driver.switchTo().frame("frame1");
        //frameMethods.switchToFrame("frame1");
        //WebElement childFrame = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
        //driver.switchTo().frame(childFrame);
        //frameMethods.switchToFrame(childFrame);

        //WebElement text = driver.findElement(By.xpath("//p"));
        //System.out.println(text.getText());
        //driver.switchTo().defaultContent();
        //frameMethods.switchToDefault();


    }
}
