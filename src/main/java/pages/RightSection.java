package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import init_classes.ChromeSetup;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static data.enums.rightSection.InfoPanelHeaders.INFO_PANEL_HEADERS;

public class RightSection extends ChromeSetup {


    @FindBy(css = ".info-panel-body-log")
    SelenideElement logBody;

    @FindBy(css = ".info-panel-body-result")
    SelenideElement resultIBody;

    @FindBy(css = ".info-panel-header")
    ElementsCollection headers;

    //check right section interface
    public void checkInterface() {

        //headers
        headers.shouldHaveSize(2);
        for(SelenideElement header: headers) {
            header.shouldBe(visible);
        }
        headers.shouldHave(texts(INFO_PANEL_HEADERS.getHeaders()));

        //bodies
        logBody.shouldBe(visible);
        resultIBody.shouldBe(visible);
    }
}
