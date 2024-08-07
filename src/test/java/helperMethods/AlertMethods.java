package helperMethods;

import lombok.AllArgsConstructor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@AllArgsConstructor
public class AlertMethods {

    public WebDriver driver;

    //definim metode generale pt interactiunea cu alerte
    public void waitForAlert(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(){
        waitForAlert();
        Alert timerAlert = driver.switchTo().alert();
        System.out.println(timerAlert.getText());
        timerAlert.accept();
    }

    public void dismissAlert(){
        waitForAlert();
        Alert timerAlert = driver.switchTo().alert();
        System.out.println(timerAlert.getText());
        timerAlert.dismiss();
    }

    public void fillAlert(String value){
        waitForAlert();
        Alert promptAlert = driver.switchTo().alert();
        System.out.println(promptAlert.getText());
        promptAlert.sendKeys(value);
        promptAlert.accept();
    }
}
