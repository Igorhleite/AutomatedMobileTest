package br.ce.wcaquino.appium;
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

public class ChallengerOne {

    @Test
    public void FullForms() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        // desiredCapabilities.setCapability("appPackage", "com.tricolorcat.calculator");
        // desiredCapabilities.setCapability("appActivity", "com.tricolorcat.calculator.MainActivity");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\igor\\IdeaProjects\\CursoAppium\\src\\main\\resources\\CTAppium_1_2.apk");


        AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Find and enter "Formulario"
        driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();

        // Just verify about render of elements on screen
        MobileElement Text = driver.findElement(By.className("android.widget.EditText"));

        MobileElement Selection = driver.findElement(By.className("android.widget.Spinner"));

        MobileElement CheckBox = driver.findElement(By.className("android.widget.CheckBox"));
        Assert.assertTrue(CheckBox.getAttribute("checked").equals("false"));

        MobileElement sWitch = driver.findElement(By.className("android.widget.Switch"));
        Assert.assertTrue(sWitch.getAttribute("checked").equals("true"));

        MobileElement SaveButton = driver.findElement(By.xpath("//android.widget.TextView[@text='SALVAR']"));

        //Actions
        Text.sendKeys("Igor");

        Selection.click();
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();

        CheckBox.click();

        sWitch.click();

        SaveButton.click();

        //Verify
        String ImputedText = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Igor']")).getText();
        Assert.assertEquals("Nome: Igor", ImputedText);

        String Console = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]")).getText();
        Assert.assertEquals("Console: ps4", Console);

        String sWitchStatus = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]")).getText();
        Assert.assertEquals("Switch: Off", sWitchStatus);

        String checkStatus = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]")).getText();
        Assert.assertEquals("Checkbox: Marcado", checkStatus);


        driver.quit();
    }
}




