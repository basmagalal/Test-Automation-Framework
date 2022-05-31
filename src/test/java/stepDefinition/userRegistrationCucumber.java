package stepDefinition;

import cucumberRunner.testRunnerCucumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.RegistrationPage;
import tests.TestBase;

import static io.netty.util.internal.SystemPropertyUtil.contains;

public class userRegistrationCucumber extends TestBase {


    HomePage homePage;
    RegistrationPage registrationPage;

    @Given("the user in the home page")
    public void the_user_in_the_home_page() {
        homePage=new HomePage(driver);
        homePage.openRegestrationPage();

      //  throw new io.cucumber.java.PendingException();
    }
    @When("user clicks on register button")
    public void user_clicks_on_register_button() {
        Assert.assertEquals(driver.getTitle(),"nopCommerce demo store. Register");
        registrationPage=new RegistrationPage(driver);


       // throw new io.cucumber.java.PendingException();
    }

    @And("I entered {string},{string},{string},{string}")
    public void iEntered(String fname, String lname, String mail, String password) {
        registrationPage.userRegestration(fname,lname,mail,password);
        registrationPage.logoutbtn.click();


    }
    @Then("the registration page is displayed successfully")
    public void the_registration_page_is_displayed_successfully() {
        //registrationPage.clickOnRegisterButton();
        //throw new io.cucumber.java.PendingException();
    }



}

