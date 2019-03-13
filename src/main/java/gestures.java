import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class gestures extends base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = base.Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();

        //Tap
        TouchAction t = new TouchAction(driver);
        WebElement expandList = driver.findElementByXPath
                ("//android.widget.TextView[@text='Expandable Lists']");
        t.tap(TapOptions.tapOptions()
                        .withElement(element(expandList)))
                        .perform();

        //Go to custom adapter page
        driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();

        //Long press the element
        WebElement peopleName = driver.findElementByXPath
                ("//android.widget.TextView[@text='People Names']");
        t.longPress(LongPressOptions.longPressOptions()
                                    .withElement(element(peopleName))
                                    .withDuration(Duration.ofSeconds(2)))
                                    .release()
                                    .perform();

        System.out.println(driver.findElementById("android:id/title").isDisplayed());
    }
}
