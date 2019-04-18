import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class browser extends baseChrome {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = baseChrome.Capabilities("emulator");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.google.com");
    }
}