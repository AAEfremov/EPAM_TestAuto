package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.annotations.BeforeClass;
import pages.DiffElementsPage;
import pages.IndexPage;

import static com.codeborne.selenide.Selenide.page;
import static data.enums.diffElementsPage.CheckboxLabels.WATER;
import static data.enums.diffElementsPage.CheckboxLabels.WIND;
import static data.enums.diffElementsPage.ColorsOptions.COLORS_OPTIONS;
import static data.enums.diffElementsPage.ColorsOptions.YELLOW;
import static data.enums.diffElementsPage.RadioLabels.RADIO_LABELS;
import static data.enums.diffElementsPage.RadioLabels.SELEN;

public class IndexPageLoginAndCheckInterfaceSteps {

    private IndexPage indexPage;
    private DiffElementsPage diffElementsPage;


    /*@BeforeClass
    public void pagesInit(){
        indexPage = page(IndexPage.class);

    }*/


    @Given("^I am on Index Page$")
    public void openIndexPage() {
        indexPage = page(IndexPage.class);
        indexPage.openPage();
    }

    @When("^I login as \"([^\"]*)\"/\"([^\"]*)\"$")
    public void login(String name, String password) {

        indexPage.login(name, password);

    }

    @Then("^Name \"([^\"]*)\" must be displayed on the right upper corner of the page$")
    public void checkUsername(String username) {

        indexPage.checkUsername(username);
    }

    @And("^All Index page elements exist$")
    public void checkIndexPageInterface() {
        indexPage.checkInterface();
        indexPage.checkServiceDropdown();
    }

    @Given("^I am on Different Elements Page$")
    public void openDifferentElementsPage() {

        diffElementsPage = page(DiffElementsPage.class);
        diffElementsPage.openPage();
    }

    @When("^All Different Elements page elements exist$")
    public void checkDiffElementsPageInterface() {

        diffElementsPage.checkInterface();
    }

    @And("^Select and checked all need elements$")
    public void selectAndCheckedAllNeedElements() {

        diffElementsPage.selectAndCheckCheckbox(WATER);
        diffElementsPage.selectAndCheckCheckbox(WIND);
        diffElementsPage.selectAndCheckRadio(SELEN);
        diffElementsPage.selectAndCheckDropdown(YELLOW);
    }

    @Then("^All need logs appeared in Log Section for selected elements$")
    public void allNeedLogsAppearedInLogSectionForSelectedElements() {

        diffElementsPage.checkLogEntries(WATER.getLabel(), true);
        diffElementsPage.checkLogEntries(WIND.getLabel(), true);
        diffElementsPage.checkLogEntries(RADIO_LABELS.getMetalTag(), SELEN.getLabel());
        diffElementsPage.checkLogEntries(COLORS_OPTIONS.getColorTag(), YELLOW.getColor());
    }

    @When("^Unselect and check all need elements$")
    public void unselectAndCheckAllNeedElements() {

        diffElementsPage.unselectAndCheckCheckbox(WATER);
        diffElementsPage.unselectAndCheckCheckbox(WIND);
    }

    @Then("^All need logs appeared in Log Section for unselected elements$")
    public void allNeedLogsAppearedInLogSectionForUnselectedElements() {

        diffElementsPage.checkLogEntries(WATER.getLabel(), false);
        diffElementsPage.checkLogEntries(WIND.getLabel(), false);
    }
}
