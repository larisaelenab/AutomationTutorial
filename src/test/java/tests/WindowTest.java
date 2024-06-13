package tests;

import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import helperMethods.WindowMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WindowTest {

    public WebDriver driver;

    @Test
    public void windowTest() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();

        //definim un obiect de tipul window methods
        WindowMethods windowMethods = new WindowMethods(driver);
        ElementMethods elementMethods = new ElementMethods(driver);
        PageMethods pageMethods = new PageMethods(driver);


        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,350)", "");
        pageMethods.scrollPage(0,350);
        WebElement alertsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        //alertsMenu.click();
        elementMethods.clickElement(alertsMenu);

        WebElement browserWindowsSubmenu = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        //browserWindowsSubmenu.click();
        elementMethods.clickElement(browserWindowsSubmenu);

        WebElement newTab = driver.findElement(By.id("tabButton"));
        //click intercepted
        //js.executeScript("arguments[0].click();", newTab);
        //newTab.click();
        elementMethods.clickElement(newTab);

        //interactionam cu un tab/window
        System.out.println(driver.getCurrentUrl());   //url paginii curente

        //List<String> tabs = new ArrayList<>(driver.getWindowHandles());   //gaseste cate taburi/windows sunt deschise

        //ne mutam cu focusul pe un anumit tab
        //driver.switchTo().window(tabs.get(1));

        windowMethods.switchSpecificTab(1);
        System.out.println(driver.getCurrentUrl());

        //quit - inchide browserul cu toate taburile
        //close - inchidem tabul curent
        //driver.close();
        windowMethods.closeCurrentTab();
        //driver.switchTo().window(tabs.get(0));
        windowMethods.switchSpecificTab(0);

        WebElement newWindow = driver.findElement(By.id("windowButton"));
        //newWindow.click();
        elementMethods.clickElement(newWindow);

        System.out.println(driver.getCurrentUrl());
        //List<String> windows = new ArrayList<>(driver.getWindowHandles());   //gaseste cate taburi/windows sunt deschise

        //ne mutam cu focusul pe un anumit tab
        //driver.switchTo().window(windows.get(1));
        windowMethods.switchSpecificTab(1);
        System.out.println(driver.getCurrentUrl());

        //quit - inchide browserul cu toate taburile
        //close - inchidem tabul curent
        //driver.close();
        windowMethods.closeCurrentTab();
        //driver.switchTo().window(windows.get(0));
        windowMethods.switchSpecificTab(0);
        System.out.println(driver.getCurrentUrl());

        //driver.close();
        driver.quit();

    }
}

