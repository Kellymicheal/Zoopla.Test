package co.uk.zoopla.stepDefinations;

import co.uk.zoopla.pages.BasePage;
import co.uk.zoopla.pages.HomePage;
import co.uk.zoopla.pages.ProductDetailsPage;
import co.uk.zoopla.pages.SearchResultPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.support.PageFactory;



public class ForSaleSearchSteps extends BasePage
{
HomePage homePage = PageFactory.initElements(Driver,HomePage.class);
    SearchResultPage searchResultPage = PageFactory.initElements(Driver, SearchResultPage.class);
    ProductDetailsPage  productDetailsPage = PageFactory.initElements(Driver, ProductDetailsPage.class);


    @Given("I navigate to zoopla homepage")
    public void i_navigate_to_zoopla_homepage()
    {

        launchurl();

    }

    @When("I enter a {string} in the search textbox")
    public void i_enter_a_in_the_search_textbox(String location)
    {

        homePage.enterLocation(location);

    }

    @When("I select {string} from minprice dropdown")
    public void i_select_from_minprice_dropdown(String minPrice)
    {
        homePage.selectMinimumPrice(minPrice);

    }

    @When("I select {string} from maxprice dropdown")
    public void i_select_from_maxprice_dropdown(String maxprice)
    {

      homePage.selectMaximumPrice(maxprice);
    }

    @When("I select {string} from propertytype dropdown")
    public void i_select_from_propertytype_dropdown(String property)
    {
        homePage.selectPropertyType(property);

    }

    @When("I select {string} from bedroom dropdown")
    public void i_select_from_bedroom_dropdown(String bed)
    {
     homePage.selectNoOfBed(bed);
    }

    @When("I click on searchbutton")
    public void i_click_on_searchbutton()
    {
        searchResultPage = homePage.clickOnSubmitButton();

    }

    @Then("A list of {string} in {string} are displayed")
    public void a_list_of_in_are_displayed(String property, String location)
    {
        searchResultPage.isSearchResultDisplayed(property, location);
        searchResultPage.isResultListDisplayed();

    }
    @Then("l click on any of the result to view more detail")
    public void iClickOnAnyOfTheResultToViewMoreDetail()
    {
        productDetailsPage = searchResultPage.clickOnAnyResultsLink();


    }


}
