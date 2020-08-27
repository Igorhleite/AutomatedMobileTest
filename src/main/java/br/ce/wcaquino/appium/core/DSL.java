package br.ce.wcaquino.appium.core;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static br.ce.wcaquino.appium.core.DiverFactory.*;

public class DSL {

    public void write(By by, String text) {
        getDriver().findElement(by).sendKeys(text);

    }

    public String findText(By by) {
        return getDriver().findElement(by).getText();
    }

}

