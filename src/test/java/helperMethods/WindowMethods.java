package helperMethods;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class WindowMethods {

    public WebDriver driver;

    //metode generale pt interactiunea cu tab/window
    public void switchSpecificTab(Integer index){
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());   //gaseste cate taburi/windows sunt deschise

        //ne mutam cu focusul pe un anumit tab
        driver.switchTo().window(tabs.get(index));
    }

    public void closeCurrentTab(){
        driver.close();
    }

}
