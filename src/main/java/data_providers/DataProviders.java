package data_providers;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "correctDataUnderImages", parallel = true)
    public Object[][] correctDataUnderImages(){
        return new Object[][] {
                {1, "To include good practices\nand ideas from successful\nEPAM projec"},
                {2, "To be flexible and\ncustomizable"},
                {3, "To be multiplatform"},
                {4, "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}};
    }
}
