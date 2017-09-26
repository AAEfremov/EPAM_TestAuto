package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import init_classes.ChromeSetup;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static data.enums.headerAndLeftSection.ServiceDropdownElements.ELEMENTS_NAMES;

class Header extends ChromeSetup {

    @FindBy(css = "a[href='page1.htm'][class ='dropdown-toggle']")
    private SelenideElement headerService;

    @FindBy(css = ".dropdown-menu li a")
    private ElementsCollection headerServiceElements;

    SelenideElement getHeaderService(){
        return headerService;
    }

    ElementsCollection getHeaderServiceElements() {
        return headerServiceElements;
    }

    void checkHeaderServiceDropdown() {

        //header SERVICE element
        headerService.click();

        //header dropdown elements
        headerServiceElements.shouldHaveSize(6);
        for (SelenideElement headerServiceElement : headerServiceElements) {
            headerServiceElement.shouldBe(visible);
        }
        headerServiceElements.shouldHave(texts(ELEMENTS_NAMES.getElementsNames()));
    }


}
