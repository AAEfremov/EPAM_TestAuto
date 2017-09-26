package Homework2;

import data_providers.DataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


import static data.HomeworkConstants.*;

public class CheckTextsUnderImages {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty(PROPERTY1, PROPERTY2);
        driver = new ChromeDriver();
        driver.navigate().to(TEST_URL1);
    }

    @AfterSuite
    public void tearDown() {
        driver.close();
    }

    @BeforeClass
    public void printInfo() {
        System.out.println("Executing threads names:");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correctDataUnderImages")
    public void checkTextsUnderImages(int n, String checkText) {
        WebElement texts = driver.findElement(By.xpath("(//span[@class = 'benefit-txt'])[" + n + "]"));
        Assert.assertEquals(texts.getText(), checkText);
        System.out.println(Thread.currentThread().getName());

    }
}
