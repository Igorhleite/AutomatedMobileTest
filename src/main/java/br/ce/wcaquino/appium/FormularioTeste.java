package br.ce.wcaquino.appium;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FormularioTeste {

    @Test
    public  void TextInsert() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        // desiredCapabilities.setCapability("appPackage", "com.tricolorcat.calculator");
        // desiredCapabilities.setCapability("appActivity", "com.tricolorcat.calculator.MainActivity");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\igor\\IdeaProjects\\CursoAppium\\src\\main\\resources\\CTAppium_1_2.apk");



        AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Find for Elements with ClassName"android.widget.TextView" and save array in elements
        List<MobileElement> elements = driver.findElements(By.className("android.widget.TextView"));
        // for(MobileElement element: elements) {
        //      System.out.println(element.getText());
        // }

        //click on element with position (1) on array
        elements.get(1).click();

        //Find for element with accessibilityId"nome" and sendKeys
        MobileElement NameCamp = driver.findElement(By.className("android.widget.EditText"));
        NameCamp.sendKeys("Igor");

        //Get text in NameCamp and compare with expected
        String text = NameCamp.getText();
        Assert.assertEquals("Igor",text);

        driver.quit();
    }



    @Test
    public  void ComboTest() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        // desiredCapabilities.setCapability("appPackage", "com.tricolorcat.calculator");
        // desiredCapabilities.setCapability("appActivity", "com.tricolorcat.calculator.MainActivity");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\igor\\IdeaProjects\\CursoAppium\\src\\main\\resources\\CTAppium_1_2.apk");



        AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



        //Find for Elements with ClassName"android.widget.TextView" and save array in elements

        driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();

        driver.findElement(By.xpath("//android.widget.Spinner[@index='2']")).click();



        driver.quit();
    }

}
