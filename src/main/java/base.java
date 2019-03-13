import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class base {
    public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {
        File f = new File("src/ApiDemos-debug.apk");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "XL");
        cap.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());

        AndroidDriver<AndroidElement> driver =
                new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        return driver;
        //AndroidUIAutomator
    }
}
