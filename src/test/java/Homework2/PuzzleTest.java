package Homework2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static core.HomeworkConstants1.*;

public class PuzzleTest {
    WebDriver driver;
    long methodStart;

    @BeforeSuite
    public void setProperties(){
        System.setProperty(PROPERTY1, PROPERTY2);
    }

    @BeforeTest
    public void initiateDriver(){
        driver = new ChromeDriver();
        driver.navigate().to(TEST_URL1);
    }

    @BeforeClass
    public void titleOutput(){
        System.out.println(driver.getTitle());
        methodStart = System.currentTimeMillis();

    }

    @AfterMethod
    public void timeForTestOutput(){
        System.out.println("Time spent for test: " + (System.currentTimeMillis() - methodStart) + " ms");
    }

    @AfterTest
    public void closeDriver(){
        driver.close();
    }

    @AfterSuite
    public void tearDown(){
        if(driver.toString().contains("null")) {
            driver.quit();
        }
    }
    @Test
    public void simpleEPAMTest() {
        Assert.assertEquals(driver.getTitle(),
                "EPAM | Software Product Development Services");
    }
}
