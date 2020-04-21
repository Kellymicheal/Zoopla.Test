package co.uk.zoopla.hooks;

import co.uk.zoopla.common.BrowserClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import sun.java2d.pipe.SpanShapeRenderer;
import sun.misc.Launcher;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Hook extends BrowserClass
{
    private String chromeBrowser = "Chrome";
    public Scenario scenario;


 @Before
 public void setUp(Scenario scenario)
 {
     this.scenario = scenario;
     launchBrowser("Chrome");
 }
 @After
    public void teardown()
 {
     String timeNow = new SimpleDateFormat("HHmmss").format(new GregorianCalendar().getTime());
     String fileName = String.format("screenshot_%s", timeNow);

     if (scenario.isFailed())
     {
         try {
             byte[] screenshort = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
             scenario.embed(screenshort, fileName);

         }catch (Exception e)
         {
             e.printStackTrace();
         }
     }
     CloseBrowser();
 }

}
