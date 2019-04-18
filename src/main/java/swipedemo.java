import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class swipedemo extends base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = base.Capabilities("emulator");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
        driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
        driver.findElementByXPath("//*[@content-desc='9']").click();

        TouchAction t = new TouchAction(driver);

        //Long press for 1 sec
        //Move to another element
        //Release
        WebElement baseNumber = driver.findElementByXPath
                ("//*[@content-desc='15']");
        WebElement targetNumber = driver.findElementByXPath
                ("//*[@content-desc='45']");

        t.longPress(LongPressOptions.longPressOptions()
                                    .withElement(element(baseNumber))
                                    .withDuration(Duration.ofSeconds(1)))
                                    .moveTo(element(targetNumber))
                                    .release()
                                    .perform();

        System.out.println(driver.findElementById("android:id/minutes").getText());
    }
}