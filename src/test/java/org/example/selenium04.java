package org.example;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class selenium04 {
    @Test
    public void testMethod01() throws InterruptedException {

        EdgeDriver driver = new EdgeDriver();
        //driver.get("https://sdet.live");
        driver.get("https://www.conestogac.on.ca/");
      //  Thread.sleep(2000);
        // No back, forward allowed in case of get
        //navigate.to, forward, back
        //http protocol is must
        //driver.navigate().to("https://thetestingacademy.com");
        driver.navigate().to("https://www.conestogac.on.ca/fulltime");
        Thread.sleep(2000);
        //goes back to conestoga college page
        driver.navigate().back();
        //goes forward to full time program pages
        driver.navigate().forward();
        //output as title - full time programs
        System.out.println(driver.getTitle());
        driver.quit();
    }
}