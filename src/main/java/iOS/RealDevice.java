package iOS;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class RealDevice {
    public static void main(String[] args) throws MalformedURLException {
        //Install these first before we can start running test on real devices
        //brew install libimobiledevice
        //brew install ios-deploy

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.2");
        //cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        cap.setCapability(MobileCapabilityType.APP, "//Users//hungpham//Desktop//UICatalog.app");

        //Real device test settings
        cap.setCapability("xcodeOrgId",""); //iOS development team ID
        cap.setCapability("xcodeSigningId","iPhone Developer");
        cap.setCapability("udid",""); //Can get from itunes
        cap.setCapability("updateWDABundleId","");//Get from XCode, team specific

        IOSDriver<IOSElement> driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
