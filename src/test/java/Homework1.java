import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

import static core.HomeworkConstants1.*;

public class Homework1 {

    @Test
    public void addPersonToLogsTest() throws IOException {
        System.setProperty(PROPERTY1, PROPERTY2);
        WebDriver driver = new ChromeDriver();
        // Open test site by URL
        driver.navigate().to(TEST_URL);
        driver.manage().window().maximize();

        // Assert Browser title
        Assert.assertEquals(driver.getTitle(), INDEX_PAGE);

        // Perform login
        WebElement openLogin = driver.findElement(By.xpath("//*[@class = 'dropdown-toggle' and @href = '#']"));
        openLogin.click();
        Assert.assertTrue(openLogin.isDisplayed());
        WebElement login = driver.findElement(By.xpath("//*[@id = 'Login']"));
        login.sendKeys(LOGIN);
        WebElement password = driver.findElement(By.xpath("//*[@id = 'Password']"));
        password.sendKeys(PASSWORD);
        TakeScreenshot(driver, 1);
        WebElement submitButton = driver.findElement(By.xpath("//*[@class = 'uui-button dark-blue btn-login']"));
        submitButton.click();

        // Assert User name in the left-top side of screen that user is loggined
        Assert.assertEquals(openLogin.getText().toLowerCase(), TEST_NAME);
        TakeScreenshot(driver, 2);

        // Open Contact form
        WebElement contactForm = driver.findElement(By.xpath("//*[@class = 'sidebar-menu']//*[@href = 'page1.htm']"));
        contactForm.click();

        // Assert Browser title
        Assert.assertEquals(driver.getTitle(), CONTACT_FORM);
        TakeScreenshot(driver, 3);

        // Input your first and last name in text fields
        WebElement firstName = driver.findElement(By.xpath("//*[@id = 'Name']"));
        firstName.sendKeys(FIRST_NAME);
        WebElement lastName = driver.findElement(By.xpath("//*[@id = 'LastName']"));
        lastName.sendKeys(LAST_NAME);
        // Click submit button
        WebElement submitContactButton = driver.findElement(By.xpath("//*[@class = 'uui-button dark-blue' and @type = 'submit']"));
        submitContactButton.click();

        // Assert: in the log section a new raw has displayed which contains text "submit"
        WebElement log = driver.findElement(By.xpath("//*[@class = 'info-panel-body info-panel-body-log']"));
        Assert.assertTrue(log.getText().contains(FIRST_NAME));
        Assert.assertTrue(log.getText().contains(LAST_NAME));
        Assert.assertTrue(log.getText().contains(SUBMIT));
        TakeScreenshot(driver, 4);

        // Close browser
        driver.close();
    }

    // Taking and saving screenshots of browser window during testing
    private void TakeScreenshot(WebDriver driver, int i) throws IOException {
        TakesScreenshot sc = (TakesScreenshot)driver;
        File screensFile = sc.getScreenshotAs(OutputType.FILE);
        switch (i) {
                case 1: org.apache.commons.io.FileUtils.copyFile(screensFile, new File(PATH1));
                        break;
                case 2: org.apache.commons.io.FileUtils.copyFile(screensFile, new File(PATH2));
                        break;
                case 3: org.apache.commons.io.FileUtils.copyFile(screensFile, new File(PATH3));
                        break;
                case 4: org.apache.commons.io.FileUtils.copyFile(screensFile, new File(PATH4));
                        break;
                default: break;
        }


    }
}
