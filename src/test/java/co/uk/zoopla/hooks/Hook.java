package co.uk.zoopla.hooks;

import co.uk.zoopla.common.BrowserClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import sun.misc.Launcher;

public class Hook extends BrowserClass
{
    private String chromeBrowser = "Chrome";
 @Before
 public void setUp()
 {
     launchBrowser("Chrome");
 }
 @After
    public void teardown()
 {
     CloseBrowser();
 }

}
