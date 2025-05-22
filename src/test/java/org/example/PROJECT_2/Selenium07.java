package org.example.PROJECT_2;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Selenium07 {

    @Test
    @Description("Verify Positive test case for valid id and password")
    public void test_positive() throws Exception{
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");
        // 1. go to website and verify title and link
        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        System.out.println(driver.getTitle());

        assertThat(driver.getTitle()).isNotBlank().isNotEmpty().isEqualTo("CURA Healthcare Service");
        assertThat(driver.getCurrentUrl()).isEqualTo("https://katalon-demo-cura.herokuapp.com/");
        Thread.sleep(2000);
        /*
        2. find make an appointment link and click
        <a id="btn-make-appointment"
        href="./profile.php#login"
        class="btn btn-dark btn-lg">
        Make Appointment</a>
        */
        WebElement link_free_trail_element = driver.findElement(By.id("btn-make-appointment"));
        link_free_trail_element.click();
        Thread.sleep(2000);

      /*
      3.find input for username and input valid input
       <input type="text"
        class="form-control"
        id="txt-username"
        name="username"
        placeholder="Username"
        value=""
        autocomplete="off">
       */
        WebElement emailInputBox = driver.findElement(By.id("txt-username"));
        emailInputBox.sendKeys("John Doe");
        Thread.sleep(2000);

        /*
        4. find input for password and input valid password
        <input type="password"
        class="form-control"
        id="txt-password"
        name="password"
        placeholder="Password"
        value="" autocomplete="off">
         */
        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("ThisIsNotAPassword");
        Thread.sleep(2000);

        /*
        5.find submit button and click
        <button id="btn-login"
        type="submit"
        class="btn btn-default">
        Login</button>
         */
        WebElement buttonSubmit = driver.findElement(By.id("btn-login"));
        buttonSubmit.click();
        Thread.sleep(3000);

        /*
        6. select from options
        <select id="combo_facility" name="facility" class="form-control">
            <option value="Tokyo CURA Healthcare Center">Tokyo CURA Healthcare Center</option>
            <option value="Hongkong CURA Healthcare Center">Hongkong CURA Healthcare Center</option>
            <option value="Seoul CURA Healthcare Center">Seoul CURA Healthcare Center</option>
        </select>
         */
        WebElement options = driver.findElement(By.id("combo_facility"));
        // Create Select instance
        Select select = new Select(options);
        select.selectByVisibleText("Hongkong CURA Healthcare Center");
        Thread.sleep(2000);

        /*
        7. find checkbox and click
        <input type="checkbox"
        id="chk_hospotal_readmission"
        name="hospital_readmission"
        value="Yes">
         */
        WebElement checkbox = driver.findElement(By.id("chk_hospotal_readmission"));
        checkbox.click();
        Thread.sleep(2000);

        /*
        8. find radio button and make selection
        <div class="col-sm-4">
             <label class="radio-inline">
                 <input type="radio" name="programs" id="radio_program_medicare" value="Medicare" checked=""> Medicare
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="programs" id="radio_program_medicaid" value="Medicaid"> Medicaid
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="programs" id="radio_program_none" value="None"> None
                        </label>
                    </div>
         */
        WebElement radio = driver.findElement(By.id("radio_program_medicaid"));
        radio.click();
        Thread.sleep(3000);


        /*
        9.Find input for calender date selection and enter date
        <input type="text"
        class="form-control"
        id="txt_visit_date"
        name="visit_date"
        placeholder="dd/mm/yyyy"
        autocomplete="off"
        required="">
         */
        WebElement calender = driver.findElement(By.id("txt_visit_date"));
        calender.sendKeys("25/06/2025");
        Thread.sleep(2000);

        /*
        10. find comment input box and make comment
        <textarea class="form-control"
        id="txt_comment"
        name="comment"
        placeholder="Comment"
        rows="10">
        </textarea>
         */
        WebElement comment = driver.findElement(By.id("txt_comment"));
        comment.sendKeys("Need Appointment");
        Thread.sleep(3000);

        /*
        11. find book appointment button and click
        <button id="btn-book-appointment"
        type="submit"
        class="btn btn-default">
        Book Appointment</button>
         */
        WebElement buttonBookAppointment = driver.findElement(By.id("btn-book-appointment"));
        buttonBookAppointment.click();
        Thread.sleep(3000);


       // 12. find tag for appointment confirmation and verify
        // <h2>Appointment Confirmation</h2>
        WebElement heading = driver.findElement(By.tagName("h2"));
        assertThat(heading.getText()).isNotBlank().isNotEmpty().isEqualTo("Appointment Confirmation");
        Thread.sleep(3000);

        /*
        13. verify all the selection made
        <p id="facility">Hongkong CURA Healthcare Center</p>
        <div class="col-xs-8">
                    <p id="hospital_readmission">Yes</p>
                </div>
                <p id="program">Medicaid</p>
                <p id="visit_date">25/06/2025</p>
                <div class="col-xs-8">
                    <p id="comment">Need appointment</p>
                </div>
         */
        // Facility
        WebElement facility = driver.findElement(By.id("facility"));
        assertThat(facility.getText()).isNotBlank().isNotEmpty().isEqualTo("Hongkong CURA Healthcare Center");
        //System.out.println(facility.getText());

        // Hospital Readmission
        WebElement readmission  = driver.findElement(By.id("hospital_readmission"));
        assertThat(readmission .getText()).isNotBlank().isNotEmpty().isEqualTo("Yes");
       // System.out.println(readmission.getText());

        // Program
        WebElement program  = driver.findElement(By.id("program"));
        assertThat(program .getText()).isNotBlank().isNotEmpty().isEqualTo("Medicaid");
       // System.out.println(program.getText());

        // Visit Date
        WebElement visitDate  = driver.findElement(By.id("visit_date"));
        assertThat(visitDate .getText()).isNotBlank().isNotEmpty().isEqualTo("25/06/2025");
       // System.out.println(visitDate.getText());

        // Comment
        WebElement comment_made  = driver.findElement(By.id("comment"));
        assertThat(comment_made .getText()).isNotBlank().isNotEmpty().isEqualTo("Need Appointment");
        // System.out.println(comment_made.getText());

        /*
        14. find go to homepage and click
        <a class="btn btn-default"
        href="https://katalon-demo-cura.herokuapp.com/">
        Go to Homepage</a>
         */
        WebElement link_to_home = driver.findElement(By.partialLinkText("Go to Homepage"));
        link_to_home.click();
        Thread.sleep(3000);
        driver.quit();
    }
}
