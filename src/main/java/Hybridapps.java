import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Hybridapps {
    public static void main(String[] args) throws MalformedURLException {
        //Install the appview test from Google Play before run this test

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");

        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.snc.test.webview2");
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.snc.test.webview.activity.MainActivity");

        AndroidDriver<WebElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println(driver.getContext());
        driver.findElementById("com.snc.test.webview2:id/action_go_website").click();
        driver.findElementById("android:id/button1").click();

        //Switch to web context
        System.out.println(driver.getContextHandles());
        Set<String> s = driver.getContextHandles();
        driver.context("WEBVIEW_com.snc.test.webview2");

        //To enable WebView debugging, call the static method setWebContentsDebuggingEnable on the webview class
        driver.findElementByXPath("//input[@name='q']").sendKeys("Test Hybrid App");
        //driver.findElementByXPath("//button[@aria-label='Google Search']").click();

        //Switch back to native app
        driver.context("NATIVE_APP");
        driver.findElementByClassName("android.widget.ImageButton").click();
        driver.findElementByXPath("//android.widget.CheckedTextView[@text='Device Info']").click();
    }
}
