package co.uk.zoopla.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search-input-location")
    private WebElement locationField;
    @FindBy(css = ".ui-button-primary.ui-cookie-accept-all-medium-large")
    private WebElement acceptAllCookie;
    @FindBy(id = "forsale_price_min")
    private WebElement minPrice;
    @FindBy(id = "forsale_price_max")
    private WebElement maxPrice;
    @FindBy(id = "property_type")
    private WebElement propertyType;
    @FindBy(id = "beds_min")
    private  WebElement noOfBed;
    @FindBy(id = "search-submit")
    private WebElement submitButton;

    public void enterLocation(String location) {

        acceptAll();
        locationField.clear();
        locationField.sendKeys(location);
        locationField.click();

    }

    public void acceptAll() {
        acceptAllCookie.click();


    }

    public void selectMinimumPrice(String miniPrice)
    {
        minPrice.click();
        selectElementByVisibleText(minPrice,miniPrice);

    }

    public void selectMaximumPrice(String maxiPrice)
    {
        selectElementByVisibleText(maxPrice, maxiPrice);

    }

    public  void selectPropertyType(String property)

    {
        selectElementByVisibleText(propertyType, property);
      }
      public void selectNoOfBed(String bed)

      {
       selectElementByVisibleText(noOfBed,bed);
      }
      public SearchResultPage clickOnSubmitButton()
      {
          submitButton.click();
          return new SearchResultPage(driver);
      }
}
