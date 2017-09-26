package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import init_classes.ChromeSetup;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static data.HomeworkConstants.TEST_URL;
import static data.enums.indexPage.TextsAbovePictures.ABOVE_TEXTS;
import static data.enums.indexPage.TextsUnderPictures.UNDER_TEXTS;

public class IndexPage extends ChromeSetup {

    private Header header = page(Header.class);
    private LeftSection leftSection = page(LeftSection.class);

    @FindBy(css = ".fa-user")
    private SelenideElement loginForm;

    @FindBy(css = "#Login")
    private SelenideElement usernameField;

    @FindBy(css = "#Password")
    private SelenideElement passwordField;

    @FindBy(css = ".fa-sign-in")
    private SelenideElement submitButton;

    @FindBy(css = ".profile-photo span")
    private SelenideElement usernameProfile;

    @FindBy(css = ".benefit-icon")
    private ElementsCollection pictures;

    @FindBy(css = ".icon-practise")
    private SelenideElement icon_practise;

    @FindBy(css = ".icon-custom")
    private SelenideElement icon_custom;

    @FindBy(css = ".icon-multi")
    private SelenideElement icon_multi;

    @FindBy(css = ".icon-base")
    private SelenideElement icon_base;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection textsUnderPictures;

    @FindBy(css = ".text-center")
    private ElementsCollection textsAbovePictures;

    public IndexPage() {
        baseUrl = TEST_URL;
    }

    //open Index Page
    public void openPage() {
        open("/");
    }

    //enter the account
    public void login(String loginName, String password){
        loginForm.click();
        usernameField.sendKeys(loginName);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    //check current user
    public void checkUsername(String userName) {
        usernameProfile.shouldBe(visible);
        usernameProfile.shouldHave(text(userName));
    }

    //check page interface
    public void checkInterface(){

        //pictures
        pictures.shouldHaveSize(4);
        icon_practise.shouldBe(visible);
        icon_custom.shouldBe(visible);
        icon_multi.shouldBe(visible);
        icon_base.shouldBe(visible);

        textsUnderPictures.shouldHaveSize(4);
        for (SelenideElement text : textsUnderPictures) {
            text.shouldBe(visible);
        }
        textsUnderPictures.shouldHave(texts(UNDER_TEXTS.getTexts())); //!!!: failed in maven executor

        textsAbovePictures.shouldHaveSize(2);
        for (SelenideElement text : textsAbovePictures) {
            text.shouldBe(visible);
        }
        textsAbovePictures.shouldHave(texts(ABOVE_TEXTS.getTexts())); //!!!: failed in maven executor
    }

    //check SERVICE dropdown menu
    public void checkServiceDropdown() {

        header.checkHeaderServiceDropdown();
        leftSection.checkLeftServiceDropdown();
    }
}
