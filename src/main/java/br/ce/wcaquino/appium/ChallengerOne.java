package br.ce.wcaquino.appium;
import br.ce.wcaquino.appium.core.DSL;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import br.ce.wcaquino.appium.core.DiverFactory;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ChallengerOne {

    private AndroidDriver<MobileElement> driver;

    private DSL dsl = new DSL();

    @Before
    public void getMobileElementAndroidDriver() throws MalformedURLException {
       driver = DiverFactory.getDriver();

        //Find "Formulario" and click
        driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();

    }

    @After
    public void turnOff() {
        DiverFactory.killDriver();
    }


    @Test
    public void FullForms() throws MalformedURLException {

        // Just verify about render of elements on screen
        dsl.write(By.className("android.widget.EditText"), "Igor" );


        MobileElement Selection = driver.findElement(By.className("android.widget.Spinner"));

        MobileElement CheckBox = driver.findElement(By.className("android.widget.CheckBox"));
        Assert.assertTrue(CheckBox.getAttribute("checked").equals("false"));

        MobileElement sWitch = driver.findElement(By.className("android.widget.Switch"));
        Assert.assertTrue(sWitch.getAttribute("checked").equals("true"));

        MobileElement SaveButton = driver.findElement(By.xpath("//android.widget.TextView[@text='SALVAR']"));

        //Actions

        Selection.click();
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();

        CheckBox.click();

        sWitch.click();

        SaveButton.click();

        //Verify
        String ImputedText = dsl.findText(By.xpath("//android.widget.TextView[@text='Nome: Igor']"));
        Assert.assertEquals("Nome: Igor", ImputedText);

        String Console = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]")).getText();
        Assert.assertEquals("Console: ps4", Console);

        String sWitchStatus = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]")).getText();
        Assert.assertEquals("Switch: Off", sWitchStatus);

        String checkStatus = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]")).getText();
        Assert.assertEquals("Checkbox: Marcado", checkStatus);



    }
}




