import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class miscelleanous extends base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = base.Capabilities("emulator");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println(driver.currentActivity());
        //Views - native, Hybrid, Webview
        System.out.println(driver.getContext());
        System.out.println(driver.getOrientation());
        System.out.println(driver.isDeviceLocked());

        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }
}
