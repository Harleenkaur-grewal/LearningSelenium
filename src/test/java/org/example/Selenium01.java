package org.example;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Selenium01 {
    @Test
    public void test_Selenium(){

        // In Selenium 3
        // we need to write a code to start a driver
        // System.setProperty("webdriver.gecko.driver", "path/to/firefoxdriver");

        // Selenium 4
        // FirefoxDriver driver = new FirefoxDriver();
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");
        driver.quit();

    }

}
