package co.uk.zoopla.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import javax.swing.text.html.Option;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class BrowserClass extends DriverLib
{
    private WebDriver initChrome()
    {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private WebDriver initHeadlessChrome()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "--headless");

        return new ChromeDriver(options);
    }

    private WebDriver initFirefox()
    {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private WebDriver initInternetExplorer()
    {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }

    public void launchBrowser(String browser)
            {
        switch (browser)
        {
            case "Chrome":
                Driver = initChrome();
                break;
            case "Firefox":
                Driver = initFirefox();
                break;
            case "Headless":
                Driver = initHeadlessChrome();
                break;
            case "ie":
            case "internet Explorer":
            case "Internet Explorer":
            case "internetexplorer":
            case "InternetExplorer":
            case "IE":
                Driver = initInternetExplorer();
                break;
            default:
                 Driver = initHeadlessChrome();
        }
        Driver.manage().window().maximize();
        Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );
        Driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public void CloseBrowser()
    {
        Driver.manage().deleteAllCookies();
        Driver.quit();
    }

    {

    }

}








