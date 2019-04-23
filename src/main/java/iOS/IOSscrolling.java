package iOS;

import org.openqa.selenium.JavascriptExecutor;

import java.net.MalformedURLException;
import java.util.HashMap;

public class IOSscrolling extends IOSBase {
    public static void main(String[] args) throws MalformedURLException {
        driver = capabilities();

        JavascriptExecutor js = driver;
        HashMap<String, String> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");
        scrollObject.put("element", driver.findElementByAccessibilityId("Switches").getId());
        js.executeScript("mobile: scroll", scrollObject);

        driver.findElementByAccessibilityId("Steppers").click();
        for (int i = 0; i < 3; i++)
            driver.findElementByXPath("(//XCUIElementTypeButton[@name='Increment'])[1]").click();
        System.out.println(driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"3\"]").getText());

        //Back and go to picker view
        driver.navigate().back();

        while (!driver.findElementByAccessibilityId("Picker View").isDisplayed()) {
            //JavascriptExecutor js = driver;
            //HashMap<String, String> scrollObject = new HashMap<>();
            scrollObject.put("direction", "down");
            js.executeScript("mobile: swipe", scrollObject);
        }

        driver.findElementByAccessibilityId("Picker View").click();
        driver.findElementByName("Green color component value").sendKeys("220");
        driver.findElementsByClassName("XCUIElementTypePickerWheel").get(0).sendKeys("55");
        driver.findElementByXPath("//XCUIElementTypePickerWheel[@name='Blue color component value']").sendKeys("0");
    }
}
