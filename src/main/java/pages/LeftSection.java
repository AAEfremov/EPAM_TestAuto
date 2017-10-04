package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import init_classes.ChromeSetup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static data.enums.headerAndLeftSection.ServiceDropdownElements.ELEMENTS_NAMES;
import static data.enums.headerAndLeftSection.SubMenuElements.SUB_MENU_ELEMENTS;

class LeftSection extends ChromeSetup {

    @FindBy(css = ".sub-menu")
    private SelenideElement leftService;

    @FindBy(css = "a p")
    private ElementsCollection leftServiceElements;

    @FindBy(css = ".sidebar-menu li")
    private ElementsCollection subMenuElements;

    @Step("Check left Service dropdown menu")
    void checkLeftServiceDropdown() {

        //service element
        leftService.click();

        //service dropdown elements
        leftServiceElements.shouldHaveSize(6);
        for (SelenideElement leftServiceElement : leftServiceElements) {
            leftServiceElement.shouldBe(visible);
        }
        leftServiceElements.shouldHave(texts(ELEMENTS_NAMES.getElementsNames()));
    }

    @Step("Check left section interface")
    void checkInterface() {

        //sub-menu elements
        subMenuElements.shouldHaveSize(10);
        for(SelenideElement subMenuElement: subMenuElements) {
            subMenuElement.shouldBe(visible);
        }
        subMenuElements.shouldHave(texts(SUB_MENU_ELEMENTS.getNames()));
    }

}
