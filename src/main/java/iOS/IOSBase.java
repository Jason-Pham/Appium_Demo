package iOS;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class IOSBase {
    static IOSDriver<IOSElement> driver;

    public static IOSDriver<IOSElement> capabilities() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Xs Max");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.2");

        //for iOS 10.2+
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        cap.setCapability(MobileCapabilityType.APP, "//Users//hungpham//Desktop//UICatalog.app");

        IOSDriver<IOSElement> driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }
}
