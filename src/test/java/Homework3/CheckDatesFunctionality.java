package Homework3;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DatesPage;
import pages.IndexPage;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.page;
import static data.enums.DatesPage.SliderOffsets.*;
import static data.enums.indexPage.LoginCredentials.USER1;

public class CheckDatesFunctionality {

    private IndexPage indexPage;
    private DatesPage datesPage;

    @BeforeClass
    public void pagesInit() {
        indexPage = page(IndexPage.class);
        datesPage = page(DatesPage.class);
    }

    @Test
    public void checkDatesFunctionality() {

        //open home page: https://jdi-framework.github.io/tests
        indexPage.openPage();

        //login to the account and check the user name
        indexPage.login(USER1.getLogin(), USER1.getPassword());

        //check that user name is correct
        indexPage.checkUsername(USER1.getUsername());

        //open Dates Page
        datesPage.openPage();

        //scroll down Dates Page
        datesPage.scrollDown();

        //set and check MAX-range
        datesPage.moveLeftSliderHandleAndCheckValue(LEFT_MIN);
        datesPage.moveRightSliderHandleAndCheckValue(RIGHT_MAX);

        //set and check MIN-left range
        datesPage.moveLeftSliderHandleAndCheckValue(LEFT_MIN);
        datesPage.moveRightSliderHandleAndCheckValue(RIGHT_MIN);

        //set and check MIN-right range
        datesPage.moveRightSliderHandleAndCheckValue(RIGHT_MAX);
        datesPage.moveLeftSliderHandleAndCheckValue(LEFT_MAX);

        //set and check random range
        datesPage.moveLeftSliderHandleAndCheckValue(VALUE1);
        datesPage.moveRightSliderHandleAndCheckValue(VALUE2);
    }

    @AfterClass
    public void tearDown() {
        close();
    }
}