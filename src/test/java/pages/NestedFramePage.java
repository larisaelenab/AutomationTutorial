package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NestedFramePage extends BasePage{

    public NestedFramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>']")
    private WebElement childFrame;

    @FindBy(xpath = "//p")
    private WebElement text;

    public void interactWithNestedFrames(){
        frameMethods.switchToFrame("frame1");
        frameMethods.switchToFrame(childFrame);
        System.out.println(text.getText());
        frameMethods.switchToDefault();
    }

}
