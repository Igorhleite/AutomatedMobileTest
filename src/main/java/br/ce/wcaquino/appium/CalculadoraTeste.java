package br.ce.wcaquino.appium;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculadoraTeste {

    @Test
    public  void SomarDoisValores() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("appPackage", "com.tricolorcat.calculator");
        desiredCapabilities.setCapability("appActivity", "com.tricolorcat.calculator.MainActivity");


        AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);

        MobileElement el2 = (MobileElement) driver.findElementById("com.tricolorcat.calculator:id/btOK");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.tricolorcat.calculator:id/two");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById("com.tricolorcat.calculator:id/plus");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementById("com.tricolorcat.calculator:id/two");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("com.tricolorcat.calculator:id/equal");
        el6.click();
        MobileElement el17 = (MobileElement) driver.findElementById("com.tricolorcat.calculator:id/display");
        System.out.println(el17.getText());
        Assert.assertEquals("4", el17.getText());


        driver.quit();

    }


}
