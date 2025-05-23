package org.example.PRACTICE;

import io.qameta.allure.Description;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class selenium03 {
    @Test
    @Description("add ad blocker extension to url")
    public void testMethod01() throws InterruptedException {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addExtensions(new File("src/test/java/org/example/PRACTICE/adblock.crx"));

        EdgeDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://youtube.com");
        Thread.sleep(5000);
        driver.quit();
    }
}