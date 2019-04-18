import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

class base {
    static AndroidDriver<AndroidElement> Capabilities(String device) throws MalformedURLException {
        File f = new File("src/ApiDemos-debug.apk");

        DesiredCapabilities cap = new DesiredCapabilities();

        if(device.equals("emulator"))
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2");
        else if(device.equals("real"))
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");

        cap.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());

        return new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        /* AndroidUIAutomator */
    }
}
