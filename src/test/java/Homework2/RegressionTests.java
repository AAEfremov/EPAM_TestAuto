package Homework2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static data.HomeworkConstants.*;

public class RegressionTests {

    @Test(groups = "regression")
    public void simpleEPAMTest() {
        System.setProperty(PROPERTY1, PROPERTY2);
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(TEST_URL1);
        Assert.assertEquals(driver.getTitle(),
                "EPAM | Software Product Development Services");
        driver.close();
    }

    @Test(groups = "regression")
    public void simpleJDITest() {
        System.setProperty(PROPERTY1, PROPERTY2);
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(TEST_URL);
        Assert.assertEquals(driver.getTitle(),
                "Index Page");
        driver.close();
    }

    @Test(groups = "regression")
    public void simpleEPAMTrainingTest() {
        System.setProperty(PROPERTY1, PROPERTY2);
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(TEST_URL3);
        Assert.assertEquals(driver.getTitle(),
                "EPAM Training Portal");
        driver.close();
    }
    @Test(groups = "regression")
    public void simpleGoogleTest() {
        System.setProperty(PROPERTY1, PROPERTY2);
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(TEST_URL4);
        Assert.assertEquals(driver.getTitle(),
                "Google");
        driver.close();
    }
}
