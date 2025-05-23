package org.example.PROJECT_Flipkart;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Selenium_Flipkart {
    @Test
    @Description("Open E-commerce website and get titles and prices of product of search")

    public void testMethod01() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        //1. open the url
        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.flipkart.com/");

        assertThat(driver.getTitle())
                .isNotBlank().isNotEmpty()
                .isEqualTo("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
        assertThat(driver.getCurrentUrl())
                .isEqualTo("https://www.flipkart.com/");

        // 2. enter input into search box
        WebElement searchBox = driver.findElement(By.xpath("//input[@class='Pke_EE']"));
        searchBox.sendKeys("Earpods");

        // 3. click on search icon
        WebElement searchButton = driver.findElement(By.xpath("//button[contains(@class, '_2iLD__')]"));
        searchButton.click();

        // 4. Get list of titles of all the products appeared on search page
        List<WebElement> searchTitles = driver.findElements(By.xpath("//a[@class='wjcEIp']"));
        System.out.println(searchTitles);

        //5. Get list of prices of all the products appeared on page
        List<WebElement> searchTitlesPrices = driver.findElements(By.xpath("//div[@class='Nx9bqj']"));

        //6. Print the titles of the products along with their prices
        int size = Math.min(searchTitlesPrices.size(), searchTitles.size());

        for (int i = 0; i < size; i++) {

            System.out.println("Title : " + searchTitles.get(i).getText() + " || "
                    + "Price : " + searchTitlesPrices.get(i).getText());
        }

        Thread.sleep(3000);
        // 7. close the page
        driver.quit();

    }
}
