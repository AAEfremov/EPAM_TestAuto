package init_classes;

import static com.codeborne.selenide.Configuration.browser;
import static data.HomeworkConstants.PROPERTY1;
import static data.HomeworkConstants.PROPERTY2;

public abstract class ChromeSetup {

    //Set browser configuration
    public ChromeSetup(){

        System.setProperty(PROPERTY1, PROPERTY2);
        browser = "CHROME";
    }

}
