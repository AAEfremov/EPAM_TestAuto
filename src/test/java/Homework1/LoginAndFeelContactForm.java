package Homework1;

import data.enums.ContactFormPage.UserData;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import static data.HomeworkConstants.*;
import static data.enums.ContactFormPage.UserData.*;
import static data.enums.indexPage.LoginCredentials.*;

public class LoginAndFeelContactForm {

    private WebDriver driver;

    @BeforeMethod
    public void setUp(Method method) {
        System.setProperty(PROPERTY1, PROPERTY2);
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void loginAndFillContactForm() throws IOException {
        // Open test site by URL
        driver.navigate().to(TEST_URL1);
        driver.manage().window().maximize();

        // Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Index Page");

        // Perform login
        WebElement openLogin = driver.findElement(By.xpath("//*[@class = 'dropdown-toggle' and @href = '#']"));
        openLogin.click();
        Assert.assertTrue(openLogin.isDisplayed());
        WebElement login = driver.findElement(By.xpath("//*[@id = 'Login']"));
        login.sendKeys(USER1.getLogin());
        WebElement password = driver.findElement(By.xpath("//*[@id = 'Password']"));
        password.sendKeys(USER1.getPassword());
        TakeScreenshot(driver, 1);
        WebElement submitButton = driver.findElement(By.xpath("//*[@class = 'uui-button dark-blue btn-login']"));
        submitButton.click();

        // Assert User name in the left-top side of screen that user is loggined
        Assert.assertEquals(openLogin.getText().toLowerCase(), USER1.getUsername().toLowerCase());
        TakeScreenshot(driver, 2);

        // Open Contact form
        WebElement contactForm = driver.findElement(By.xpath("//*[@class = 'sidebar-menu']//*[@href = 'page1.htm']"));
        contactForm.click();

        // Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Contact Form");
        TakeScreenshot(driver, 3);

        // Input your first and last name in text fields
        WebElement firstName = driver.findElement(By.xpath("//*[@id = 'Name']"));
        firstName.sendKeys(USER_DATA1.getFirstName());
        WebElement lastName = driver.findElement(By.xpath("//*[@id = 'LastName']"));
        lastName.sendKeys(USER_DATA1.getLastName());
        // Click submit button
        WebElement submitContactButton = driver.findElement(By.xpath("//*[@class = 'uui-button dark-blue' and @type = 'submit']"));
        submitContactButton.click();

        // Assert: in the log section a new raw has displayed which contains text "submit"
        WebElement log = driver.findElement(By.xpath("//*[@class = 'info-panel-body info-panel-body-log']"));
        Assert.assertTrue(log.getText().contains(USER_DATA1.getFirstName()));
        Assert.assertTrue(log.getText().contains(USER_DATA1.getLastName()));
        Assert.assertTrue(log.getText().contains("submit"));
        TakeScreenshot(driver, 4);
    }

    // Taking and saving screenshots of browser window during testing
    private void TakeScreenshot(WebDriver driver, int i) throws IOException {
        TakesScreenshot sc = (TakesScreenshot)driver;
        File screensFile = sc.getScreenshotAs(OutputType.FILE);
        switch (i) {
                case 1: org.apache.commons.io.FileUtils.copyFile(screensFile, new File("screenshots/screen1.jpg"));
                        break;
                case 2: org.apache.commons.io.FileUtils.copyFile(screensFile, new File("screenshots/screen2.jpg"));
                        break;
                case 3: org.apache.commons.io.FileUtils.copyFile(screensFile, new File("screenshots/screen3.jpg"));
                        break;
                case 4: org.apache.commons.io.FileUtils.copyFile(screensFile, new File("screenshots/screen4.jpg"));
                        break;
                default: break;
        }


    }
}
