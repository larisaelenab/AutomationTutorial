package pages;

import helperMethods.ElementMethods;
import helperMethods.FrameMethods;
import helperMethods.PageMethods;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NestedFramePage extends BasePage {

    public NestedFramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>']")
    WebElement childFrame;

    @FindBy(xpath = "//p")
    WebElement text;

    public void interactWithNestedFrames(){
        frameMethods.switchToFrame("frame1");
        LoggerUtility.info("The user switches to a specific frame");
        frameMethods.switchToFrame(childFrame);
        LoggerUtility.info("The user switches to a child frame");
        System.out.println(text.getText());
        LoggerUtility.info("The user interacts with an element inside the child frame");
        frameMethods.switchToDefault();
        LoggerUtility.info("The user switches to primary frame");
    }

}
