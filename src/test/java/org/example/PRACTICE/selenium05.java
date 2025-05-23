package org.example.PRACTICE;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
public class selenium05 {
    @Test
    @Description("Get title of the URL page and Verify")
    public void testMethod01() throws Exception {

        // Open the link -https://www.conestogac.on.ca/fulltime
        // Verify the title and search a string in pageSource
        // Add assertion that the title is visible in the page source.

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.conestogac.on.ca/fulltime");

        // Alternate way to maximize
        //driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        // TestNG Assertion
        Assert.assertEquals(driver.getTitle(), "Full-time programs | Conestoga College Ontario");
        // AssertJ Assertion
        assertThat(driver.getTitle()).isNotBlank().isNotEmpty().isEqualTo("Full-time programs | Conestoga College Ontario");
        assertThat(driver.getCurrentUrl()).isEqualTo("https://www.conestogac.on.ca/fulltime");

        if (driver.getPageSource().contains("Full-time programs | Conestoga College Ontario")) {
            Assert.assertTrue(true);
        } else {
            throw new Exception("Heading Not Found!!");
        }
        driver.quit();
    }
}
