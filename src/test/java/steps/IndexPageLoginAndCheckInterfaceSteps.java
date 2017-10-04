package steps;

import com.codeborne.selenide.Selenide;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.regexp.RE;
import org.testng.annotations.BeforeClass;
import pages.DiffElementsPage;
import pages.IndexPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.page;
import static data.enums.diffElementsPage.CheckboxLabels.*;
import static data.enums.diffElementsPage.ColorsOptions.*;
import static data.enums.diffElementsPage.RadioLabels.*;

public class IndexPageLoginAndCheckInterfaceSteps {

    private IndexPage indexPage;
    private DiffElementsPage diffElementsPage;


    /*@BeforeClass
    public void pagesInit(){
        indexPage = page(IndexPage.class);

    }*/


    /*@Given("^I am on Index Page$")
    public void openIndexPage() {
        indexPage = page(IndexPage.class);
        indexPage.openPage();
    }*/

    @Given("^Open ([^\"]*) Page$")
    public void openPage(String page) {
        switch (page.toLowerCase()) {
            case "index":
                indexPage = page(IndexPage.class);
                indexPage.openPage();
                break;
            case "different elements":
                diffElementsPage = page(DiffElementsPage.class);
                diffElementsPage.openPage();
                break;
            default:
                break;
        }
    }

    @When("^I login as ([^\"]*)/([^\"]*)$")
    public void login(String name, String password) {

        indexPage.login(name, password);

    }

    @Then("^Name ([^\"]*) must be displayed on the right upper corner of the page$")
    public void checkUsername(String username) {

        indexPage.checkUsername(username);
    }

    @And("^All ([^\"]*) page elements exist$")
    public void checkPageInterface(String page) {
        switch (page.toLowerCase()) {
            case "index":
                indexPage.checkInterface();
                break;
            case "different elements":
                diffElementsPage.checkInterface();
                break;
            default:
                break;
        }
    }

    @And("^All elements of Header and Left Service dropdown menu exist$")
    public void checkServiceDropdown() {

        indexPage.checkServiceDropdown();
    }

    @And("^Select and check ([^\"]*) checkbox$")
    public void selectAndCheckCheckbox(String checkbox) {
        switch (checkbox.toLowerCase()) {
            case "water":
                diffElementsPage.selectAndCheckCheckbox(WATER);
                break;
            case "earth":
                diffElementsPage.selectAndCheckCheckbox(EARTH);
                break;
            case "wind":
                diffElementsPage.selectAndCheckCheckbox(WIND);
                break;
            case "fire":
                diffElementsPage.selectAndCheckCheckbox(FIRE);
                break;
            default:
                break;
        }
    }

    @And("^Select and check ([^\"]*) radio")
    public void selectAndCheckRadio(String radio) {
        switch (radio.toLowerCase()) {
            case "gold":
                diffElementsPage.selectAndCheckRadio(GOLD);
                break;
            case "silver":
                diffElementsPage.selectAndCheckRadio(SILVER);
                break;
            case "bronze":
                diffElementsPage.selectAndCheckRadio(BRONZE);
                break;
            case "selen":
                diffElementsPage.selectAndCheckRadio(SELEN);
                break;
            default:
                break;
        }
    }

    @And("^Select and check ([^\"]*) color")
    public void selectAndCheckColor(String color) {
        switch (color.toLowerCase()) {
            case "red":
                diffElementsPage.selectAndCheckColor(RED);
                break;
            case "green":
                diffElementsPage.selectAndCheckColor(GREEN);
                break;
            case "blue":
                diffElementsPage.selectAndCheckColor(BLUE);
                break;
            case "yellow":
                diffElementsPage.selectAndCheckColor(YELLOW);
                break;
            default:
                break;
        }
    }

    @Then("^All need logs appeared in Log Section for selected elements$")
    public void checkLogsSelected() {

        diffElementsPage.checkLogEntries(WATER.getLabel(), true);
        diffElementsPage.checkLogEntries(WIND.getLabel(), true);
        diffElementsPage.checkLogEntries(RADIO_LABELS.getMetalTag(), SELEN.getLabel());
        diffElementsPage.checkLogEntries(COLORS_OPTIONS.getColorTag(), YELLOW.getColor());
    }

    @When("^Unselect and check ([^\"]*) checkbox$")
    public void unselectAndCheckCheckbox(String checkbox) {

        switch (checkbox.toLowerCase()) {
            case "water":
                diffElementsPage.unselectAndCheckCheckbox(WATER);
                break;
            case "earth":
                diffElementsPage.unselectAndCheckCheckbox(EARTH);
                break;
            case "wind":
                diffElementsPage.unselectAndCheckCheckbox(WIND);
                break;
            case "fire":
                diffElementsPage.unselectAndCheckCheckbox(FIRE);
                break;
            default:
                break;
        }
    }

    @Then("^All need logs appeared in Log Section for unselected elements$")
    public void checkLogsUnselected() {

        diffElementsPage.checkLogEntries(WATER.getLabel(), false);
        diffElementsPage.checkLogEntries(WIND.getLabel(), false);
    }
}
