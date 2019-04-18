import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class UIAutomatorTest extends base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = base.Capabilities("emulator");

        //driver.findElementByAndroidUIAutomator("attribute(value)").click();
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();

        //driver.findElementsByAndroidUIAutomator("new UiSelector().property(value)");
        System.out.println(driver.findElementsByAndroidUIAutomator
                ("new UiSelector().clickable(true)").size());
    }
}