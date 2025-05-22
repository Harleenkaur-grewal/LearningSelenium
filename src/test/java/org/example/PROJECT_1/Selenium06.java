package org.example.PROJECT_1;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class Selenium06 {
    @Test
    @Description("Verify NEGATIVE test case for invalid username and password")
    public void test_Negative_case() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com");


        //  1. Find the email inputbox and enter the email
        // get default locators from html
        // <input type="email"
        // class="text-input W(100%)"
        // name="username"
        // id="login-username"  //its unique
        // data-qa="hocewoqisi">

        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("admin@admin.com");

        //  2. Find the password inputbox and enter the password
        // <input type="password"
        // class="text-input W(100%)"
        // name="password"
        // id="login-password" //its unique
        // data-qa="jobodapuxe">

        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("admin123");

        //  3. Find the submit button and click
        //<button type="submit" id="js-login-btn"
        // class="btn btn--positive btn--inverted W(100%) H(48px) Fz(16px)" onclick="login.login(event)"
        // data-qa="sibequkica">
        // </button>

        WebElement buttonSubmit = driver.findElement(By.id("js-login-btn"));
        buttonSubmit.click();

        Thread.sleep(3000);

        //  4. Find the error message and verify
        // <div
        // class="notification-box-description" - X
        // id="js-notification-box-msg"  - X
        // data-qa="rixawilomi"> // Custom Attribute(Not id, class, name)
        // Your email, password, IP address or location did not match
        // </div>

        //WebElement error_message = driver.findElement(By.id("js-notification-box-msg"));
        WebElement error_message = driver.findElement(By.className("notification-box-description"));
        // WebElement error_message = driver.findElement(By.cssSelector("[data-qa='rixawilomi']"));
        Assert.assertEquals(error_message.getText(), "Your email, password, IP address or location did not match");

        assertThat(error_message.getText()).isNotEmpty().isNotBlank().isEqualTo("Your email, password, IP address or location did not match");

        // 4. Find free-trial link and click
        // <a  - open HTML tag
        // href="https://vwo.com/free-trial/?utm_medium=website&amp;utm_source=login-page&amp;utm_campaign=mof_eg_loginpage"
        // class="text-link"
        // data-qa="bericafeqo">
        // Start a free trial
        // </a> close HTML tag


        // Link Text - Full Match
        // Partial Link Text - Partial Match

        //WebElement link_free_trail_element = driver.findElement(By.linkText("Start a free trial"));
        // link_free_trail_element.click();


        WebElement link_free_trail_element = driver.findElement(By.partialLinkText("free trial"));
        link_free_trail_element.click();

        Thread.sleep(3000);
/*
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://vwo.com/free-trial/");
*/
        // 5. Find Business email input box and enter email
        // <input
        // class="W(100%) Py(14px) input-text"
        // placeholder="name@yourcompany.com"
        // type="email"
        // id="page-v1-step1-email"
        // name="email"
        // data-qa="page-su-step1-v1-email"
        // required="">

        WebElement email = driver.findElement(By.id("page-v1-step1-email"));
        email.sendKeys("987656789dasdasd");

        Thread.sleep(3000);

        // 6. Find consent checkbox and click
        // <input
        // class="Cur(p) Flxs(0) M(0) Pos(r) T(2px)"
        // type="checkbox"
        // name="gdpr_consent_checkbox"
        // id="page-101cu-gdpr-consent-checkbox"
        // value="true"
        // data-qa="page-gdpr-consent-checkbox">

        WebElement checkbox_policy = driver.findElement(By.name("gdpr_consent_checkbox"));
        checkbox_policy.click();
        Thread.sleep(2000);

        //7. Find the button "Create Free Trial Account"
        // find by tag name
        // get list of buttons on page and click first button
        List<WebElement> button_list = driver.findElements(By.tagName("button"));
        button_list.get(0).click();
        Thread.sleep(2000);

        // 8. Find the error message displayed and verify
        // <div
        // class="C($color-red) Fz($font-size-12) Trsp($Op) Trsdu(0.15s) Op(0) invalid-input+Op(1) invalid-reason">
        // The email address you entered is incorrect.
        // </div>

        WebElement errorMessage = driver.findElement(By.className("invalid-reason"));
        Assert.assertEquals(errorMessage.getText(), "The email address you entered is incorrect.");


        Thread.sleep(3000);

        driver.quit();

    }
    }
