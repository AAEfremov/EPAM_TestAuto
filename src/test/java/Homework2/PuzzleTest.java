package Homework2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static core.HomeworkConstants1.*;

public class PuzzleTest {
    WebDriver driver;

    @BeforeSuite
    public void setProperties(){
        System.setProperty(PROPERTY1, PROPERTY2);
    }

    @BeforeTest
    public void initiateDriver(){
        driver = new ChromeDriver();
    }

    @BeforeClass
    public void driverNotOpen(){
        if(driver.toString().contains("null")) {
            driver.quit();
        }
    }

    @AfterMethod
    public void titleOutput(){
        System.out.println(driver.getTitle());
    }

    @AfterTest
    public void testTime(){
        System.out.println(System.currentTimeMillis());
    }

    @AfterSuite
    public void tearDown(){
        driver.close();
    }
    @Test
    public void simpleEPAMTest() {
        driver.navigate().to(TEST_URL1);
        Assert.assertEquals(driver.getTitle(),
                "EPAM | Software Product Development Services");
    }
}
