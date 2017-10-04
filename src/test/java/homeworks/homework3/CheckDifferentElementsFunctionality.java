package homeworks.homework3;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DiffElementsPage;
import pages.IndexPage;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.page;
import static data.enums.diffElementsPage.CheckboxLabels.WATER;
import static data.enums.diffElementsPage.CheckboxLabels.WIND;
import static data.enums.diffElementsPage.ColorsOptions.COLORS_OPTIONS;
import static data.enums.diffElementsPage.ColorsOptions.YELLOW;
import static data.enums.diffElementsPage.RadioLabels.RADIO_LABELS;
import static data.enums.diffElementsPage.RadioLabels.SELEN;
import static data.enums.indexPage.LoginCredentials.USER1;

public class CheckDifferentElementsFunctionality {

    private IndexPage indexPage;
    private DiffElementsPage diffElemPage;


    @BeforeClass
    public void pagesInit(){
        indexPage = page(IndexPage.class);
        diffElemPage = page(DiffElementsPage.class);

    }

    @Test
    public void checkDiffElementsFunctionality() {
        //open home page: https://jdi-framework.github.io/tests
        indexPage.openPage();

        //login to the account and check the user name
        indexPage.login(USER1.getLogin(), USER1.getPassword());

        //check that user name is correct
        indexPage.checkUsername(USER1.getUsername());

        //check pictures and texts on Index Page
        indexPage.checkInterface();

        //check Service dropdown menu in header and in left section
        indexPage.checkServiceDropdown();

        //open Different Elements Page
        diffElemPage.openPage();

        //check Different Elements Page interface
        diffElemPage.checkInterface();

        //select checkboxes Water and Wind
        diffElemPage.selectAndCheckCheckbox(WATER);
        diffElemPage.selectAndCheckCheckbox(WIND);

        //8 select radio Selen
        diffElemPage.selectAndCheckRadio(SELEN);

        //select in dropdown Yellow
        diffElemPage.selectAndCheckColor(YELLOW);

        //check value and(or) status (true|false) in log section
        diffElemPage.checkLogEntries(WATER.getLabel(), true);
        diffElemPage.checkLogEntries(WIND.getLabel(), true);
        diffElemPage.checkLogEntries(RADIO_LABELS.getMetalTag(), SELEN.getLabel());
        diffElemPage.checkLogEntries(COLORS_OPTIONS.getColorTag(), YELLOW.getColor());

        //unselect checkboxes Water and Wind
        diffElemPage.unselectAndCheckCheckbox(WATER);
        diffElemPage.unselectAndCheckCheckbox(WIND);

        //check value and(or) status (true|false) in log section
        diffElemPage.checkLogEntries(WATER.getLabel(), false);
        diffElemPage.checkLogEntries(WIND.getLabel(), false);

    }

    @AfterClass
    public void tearDown() {
        close();
    }
    }
