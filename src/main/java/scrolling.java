import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class scrolling extends base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = base.Capabilities("emulator");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Dimension size = driver.manage().window().getSize();
        int x = size.getWidth() / 2;
        int start = (int) (size.getHeight() * 0.60);
        int end = (int) (size.getHeight() * 0.10);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press((PointOption.point(x, start))).moveTo(PointOption.point(x, end)).release().perform();


        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector())." +
                                                    "scrollIntoView(text(\"Radio Group\"));");

    }
}
