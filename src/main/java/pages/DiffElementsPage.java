package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.enums.diffElementsPage.CheckboxLabels;
import data.enums.diffElementsPage.ColorsOptions;
import data.enums.diffElementsPage.RadioLabels;
import init_classes.ChromeSetup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;
import static data.enums.diffElementsPage.ButtonsLabels.BUTTON1_LABEL;
import static data.enums.diffElementsPage.CheckboxLabels.CHECKBOX_LABELS;
import static data.enums.diffElementsPage.ColorsOptions.COLORS_OPTIONS;
import static data.enums.diffElementsPage.RadioLabels.RADIO_LABELS;

@Title("Check Different Elements page work")
public class DiffElementsPage extends ChromeSetup {

    private Header header = page(Header.class);
    private LeftSection leftSection = page(LeftSection.class);
    private RightSection rightSection = page(RightSection.class);

    @FindBy(css = ".label-checkbox input")
    ElementsCollection checkboxes;

    @FindBy(css = ".label-checkbox")
    ElementsCollection checkboxesLabels;

    @FindBy(css = ".label-radio input")
    ElementsCollection radios;

    @FindBy(css = ".label-radio")
    ElementsCollection radiosLabels;

    @FindBy(css = "select.uui-form-element")
    SelenideElement colorsDropdownSelector;

    @FindBy(css = ".uui-form-element option")
    ElementsCollection colorOptionsSelector;

    @FindBy(css = "[name='Default Button']")
    SelenideElement defaultButton;

    @FindBy(css = "[value='Button']")
    SelenideElement button;

    @FindBy(css = ".logs li")
    ElementsCollection logs;


    @Step("Open Different Elements Page")
    public void openPage() {
        header.getHeaderService().click();
        header.getHeaderServiceElements().get(5).click();
    }

    @Step("Check page interface")
    public void checkInterface() {

        //check checkboxes
        checkboxes.shouldHaveSize(4);
        for(SelenideElement checkbox: checkboxes) {
            checkbox.shouldBe(visible);
        }
        checkboxesLabels.shouldHave(texts(CHECKBOX_LABELS.getCheckboxLabels()));

        //check radios
        radios.shouldHaveSize(4);
        for(SelenideElement radio: radios) {
            radio.shouldBe(visible);
        }
        radiosLabels.shouldHave(texts(RADIO_LABELS.getRadioLabels()));

        //check dropdown
        colorsDropdownSelector.click();
        colorOptionsSelector.shouldHaveSize(4);
        for(SelenideElement colorOption: colorOptionsSelector) {
            colorOption.shouldBe(visible);
        }
        colorOptionsSelector.shouldHave(texts(COLORS_OPTIONS.getColors()));

        //check buttons
        defaultButton.shouldBe(visible);
        defaultButton.shouldHave(text(BUTTON1_LABEL.getButtonName()));
        button.shouldBe(visible);
        //button.shouldHave(text(BUTTON2_LABEL.getButtonName())); //???

        //check left section
        leftSection.checkInterface();

        //check rightSection
        rightSection.checkInterface();
    }

    @Step("Select and check checkbox if not selected")
    public void selectAndCheckCheckbox(CheckboxLabels checkboxLabel) {

        if(!checkboxes.get(checkboxLabel.ordinal()).is(checked)) {
            checkboxes.get(checkboxLabel.ordinal()).click();
            checkboxes.get(checkboxLabel.ordinal()).shouldBe(checked);
        }
    }

    @Step("Select and check radio")
    public void selectAndCheckRadio(RadioLabels radioLabel) {

        radios.get(radioLabel.ordinal()).click();
        radios.get(radioLabel.ordinal()).shouldBe(checked);
    }

    @Step("Select and check dropdown")
    public void selectAndCheckColor(ColorsOptions color) {

        colorsDropdownSelector.click();

        //select need color
        colorOptionsSelector.get(color.ordinal()).click();
        colorsDropdownSelector.shouldHave(text(color.getColor()));
    }

    @Step("Check logs for checkboxes")
    public void checkLogEntries(String value, Boolean status){

        rightSection.logBody.shouldBe(visible);
        logs.find(text(value)).should(text(status.toString()));
    }

    @Step("Check logs for radios and dropdown")
    public void checkLogEntries(String tag, String value){

        rightSection.logBody.shouldBe(visible);
        logs.find(text(tag)).shouldHave(text(value));
    }


    @Step("Unselect and check checkbox if selected")
    public void unselectAndCheckCheckbox(CheckboxLabels checkboxLabel) {

        if (checkboxes.get(checkboxLabel.ordinal()).is(checked)) {
            checkboxes.get(checkboxLabel.ordinal()).click();
            checkboxes.get(checkboxLabel.ordinal()).shouldNotBe(checked);
        }
    }
}
