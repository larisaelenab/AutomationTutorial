package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramePage extends BasePage{

    public FramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sampleHeading")
    private WebElement iframeText;
    @FindBy(id = "sampleHeading")
    private WebElement iframeText2;
    @FindBy(xpath = "//span[text()='Nested Frames']")
    private WebElement nestedFramesFromSubmenu;

    public void interactWithBigIFrame(){
        frameMethods.switchToFrame("frame1");
        System.out.println(iframeText.getText());
        driver.switchTo().defaultContent();
    }

    public void interactWithSmallIFrame(){
        frameMethods.switchToFrame("frame2");
        System.out.println(iframeText2.getText());
        frameMethods.switchToDefault();
    }

    public void navigateToNestedFrames(){
        elementMethods.clickElement(nestedFramesFromSubmenu);
    }
}
