package tests;

import com.beust.jcommander.Parameter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static helper.ReadData.captureScreenshoot;

public class TestBase extends AbstractTestNGCucumberTests {


   public static WebDriver driver;

    @BeforeSuite
    @Parameters("browser")
    public void setUpDriver( @Optional ("chrome") String browser){

        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
        }

        else if (browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver =new EdgeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver =new FirefoxDriver();
        }

        else if (browser.equalsIgnoreCase("ie")){
            WebDriverManager.iedriver().setup();
            driver =new InternetExplorerDriver();
        }
        else if(browser.equalsIgnoreCase("headlessChrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
        driver.get("https://demo.nopcommerce.com/");

    }






    @AfterMethod
    public void recordFailure(ITestResult result){

        if (ITestResult.FAILURE== result.getStatus()) {
            captureScreenshoot(driver, result.getName());

        }
    }

    @AfterSuite
    public void StopDriver() {
      driver.close();

    }

}
