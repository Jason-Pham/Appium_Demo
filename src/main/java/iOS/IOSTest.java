package iOS;

import java.net.MalformedURLException;

public class IOSTest extends IOSBase {
    public static void main(String[] args) throws MalformedURLException {
        driver = capabilities();

        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElementByXPath("//XCUIElementTypeStaticText[@name='Text Entry']").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("Hello");
        driver.findElementByName("OK").click();
    }
}