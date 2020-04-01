package co.uk.zoopla.hooks;

import co.uk.zoopla.common.BrowserClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends BrowserClass
{
 @Before
 public void setUp()
 {
     launchBrowser("Chrome");
 }
 @After
    public void teardown()
 {
     closeBrowser();
 }

}
