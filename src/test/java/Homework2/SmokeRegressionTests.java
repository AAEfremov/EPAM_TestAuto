package Homework2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static core.HomeworkConstants1.*;

public class SmokeRegressionTests {

    @Test(groups = {"regression", "smoke"})
    public void simpleEPAMTest() {
        System.setProperty(PROPERTY1, PROPERTY2);
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(TEST_URL1);
        Assert.assertEquals(driver.getTitle(),
                "EPAM | Software Product Development Services");
        driver.close();
    }

    @Test(groups = {"regression", "smoke"})
    public void simpleJDITest() {
        System.setProperty(PROPERTY1, PROPERTY2);
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(TEST_URL2);
        Assert.assertEquals(driver.getTitle(),
                "Index Page");
        driver.close();
    }

    @Test(groups = {"regression", "smoke"})
    public void simpleInstagramTest() {
        System.setProperty(PROPERTY1, PROPERTY2);
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(TEST_URL5);
        Assert.assertEquals(driver.getTitle(),
                "Instagram");
        driver.close();
    }
}
