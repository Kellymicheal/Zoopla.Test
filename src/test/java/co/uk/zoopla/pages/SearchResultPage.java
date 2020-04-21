package co.uk.zoopla.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.stream.Location;
import java.util.List;

public class SearchResultPage extends BasePage
{
    public SearchResultPage(WebDriver driver)
    {
        this.Driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(tagName = "h1")
    private WebElement title;
    @FindBy(css =".listing-results-price.text-price")
    private List<WebElement> results;
    public void isSearchResultDisplayed(String propertyType, String location)
    {
        String titleText = title.getText();
        Assert.assertTrue(titleText.contains(propertyType));
        Assert.assertTrue(titleText.contains(location));
    }
    public void isResultListDisplayed()
    {
        Assert.assertTrue(results.size() > 0);
    }
    public ProductDetailsPage clickOnAnyResultsLink()
    {
        results.get(5).click();
        return new ProductDetailsPage(Driver);

    }

}