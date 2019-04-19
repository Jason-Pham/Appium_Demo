package iOS;

import org.openqa.selenium.JavascriptExecutor;

import java.net.MalformedURLException;
import java.util.HashMap;

public class IOSscrolling extends IOSBase {
    public static void main(String[] args) throws MalformedURLException {
        driver = capabilities();

        while (!driver.findElementByAccessibilityId("Switches").isDisplayed()) {
            JavascriptExecutor js = driver;
            HashMap<String, String> scrollObject = new HashMap<>();
            scrollObject.put("direction", "up");
            js.executeScript("mobile: swipe", scrollObject);
        }

        driver.findElementByAccessibilityId("Steppers").click();
        for(int i = 0; i < 3; i++)
            driver.findElementByXPath("(//XCUIElementTypeButton[@name='Increment'])[1]").click();
        System.out.println(driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"3\"]").getText());
    }
}
