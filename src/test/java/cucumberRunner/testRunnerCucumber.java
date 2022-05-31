package cucumberRunner;


import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(features="src/test/java/features",
        glue = {"stepDefinition"}
        ,plugin = {"pretty","html:target/cucmberReports/cucumber.html"})
public class testRunnerCucumber extends TestBase {



}
