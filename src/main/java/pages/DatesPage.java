package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import data.enums.DatesPage.SliderOffsets;
import init_classes.ChromeSetup;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.page;
import static data.enums.DatesPage.SliderHandles.LEFT_HANDLE;
import static data.enums.DatesPage.SliderHandles.RIGHT_HANDLE;

public class DatesPage extends ChromeSetup {

    private Header header = page(Header.class);
    private LeftSection leftSection = page(LeftSection.class);

    @FindBy(css = ".ui-slider-handle")
    private ElementsCollection sliderHandles;

    //open Dates Page
    public void openPage() {
        header.getHeaderService().click();
        header.getHeaderServiceElements().get(1).click();
    }

    //scroll down Dates Page
    public void scrollDown() {
        Selenide.executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    //move and check left handler
    public void moveLeftSliderHandleAndCheckValue(SliderOffsets sliderOffset) {

        actions().clickAndHold(sliderHandles.get(LEFT_HANDLE.getHandle()))
                .moveByOffset(sliderOffset.getOffset(), 0)
                .release()
                .build()
                .perform();
        sliderHandles.get(LEFT_HANDLE.getHandle()).shouldHave(exactText(sliderOffset.getValue()));
    }

    //move and check right handler
    public void moveRightSliderHandleAndCheckValue(SliderOffsets sliderOffset) {

        actions().clickAndHold(sliderHandles.get(RIGHT_HANDLE.getHandle()))
                .moveByOffset(sliderOffset.getOffset(), 0)
                .release()
                .build()
                .perform();
        sliderHandles.get(RIGHT_HANDLE.getHandle()).shouldHave(exactText(sliderOffset.getValue()));
    }
}
