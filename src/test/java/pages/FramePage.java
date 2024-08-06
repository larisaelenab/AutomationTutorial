package pages;

import helperMethods.ElementMethods;
import helperMethods.FrameMethods;
import helperMethods.PageMethods;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramePage extends BasePage{

    public FramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sampleHeading")
    WebElement iframeText;
    @FindBy(id = "sampleHeading")
    WebElement iframeText2;
    @FindBy(xpath = "//span[text()='Nested Frames']")
    WebElement nestedFramesFromSubmenu;

    public void interactWithBigIFrame(){
        frameMethods.switchToFrame("frame1");
        LoggerUtility.info("The user switches to a specific frame");
        System.out.println(iframeText.getText());
        LoggerUtility.info("The user interacts with an element inside the frame");
        frameMethods.switchToDefault();
        LoggerUtility.info("The user switches to primary frame");
    }

    public void interactWithSmallIFrame(){
        frameMethods.switchToFrame("frame2");
        LoggerUtility.info("The user switches to a specific frame");
        System.out.println(iframeText2.getText());
        LoggerUtility.info("The user interacts with an element inside the frame");
        frameMethods.switchToDefault();
        LoggerUtility.info("The user switches to primary frame");
    }

    public void navigateToNestedFrames(){
        elementMethods.clickElement(nestedFramesFromSubmenu);
        LoggerUtility.info("The user interacts with a nested frame");
    }
}
