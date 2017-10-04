package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import data.enums.DatesPage.SliderHandles;
import init_classes.ChromeSetup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.page;

@Title("Check Dates page work")

public class DatesPage extends ChromeSetup {

    private Header header = page(Header.class);
    private LeftSection leftSection = page(LeftSection.class);

    @FindBy(css = ".ui-slider")
    SelenideElement sliderTrack;

    @FindBy(css = ".ui-slider-handle")
    private ElementsCollection sliderHandles;

    @Step("Open Dates Page")
    public void openPage() {
        header.getHeaderService().click();
        header.getHeaderServiceElements().get(1).click();
    }

    @Step("Scroll down Dates Page")
    public void scrollDown() {
        Selenide.executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    private Double getStep() {

        return Double.parseDouble(String.valueOf(sliderTrack.getSize().width)) / 100.0;
    }

    //get handle current position
    private Double getCurrentPosition(SliderHandles handle) {

        Double sliderCenterPx = Double.parseDouble(sliderHandles.get(handle.getHandle()).getCssValue("left")
                .replaceAll("px", "")) + (sliderHandles.get(handle.getHandle())).getSize().width / 2.0;

        return sliderCenterPx / getStep();
    }

    @Step("Move handler")
    public void setHandlePosition(SliderHandles handle, Integer position) {

        int extraOffset = 10; //need because handles aren't accurately determined
        Double offset = (position - getCurrentPosition(handle)) * getStep();
        actions().dragAndDropBy(sliderHandles.get(handle.getHandle()), (int) Math.round(offset) + extraOffset, 0).perform();
    }

    public void checkHandlePosition(SliderHandles handle, Integer position) {

        sliderHandles.get(handle.getHandle()).shouldHave(exactText(position.toString()));
    }
}










