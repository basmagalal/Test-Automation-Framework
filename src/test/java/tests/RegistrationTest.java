package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class RegistrationTest extends TestBase{

    HomePage home;
    RegistrationPage registerPage;

    LoginPage loginPage ;

    @Test(priority = 1)
    public void userRegistrationTest(){

        home=new HomePage(driver);
        home.openRegestrationPage();
        registerPage=new RegistrationPage(driver);
        registerPage.userRegestration("omar","mohamed","omar74@gmail.com","123456");
        Assert.assertTrue(registerPage.RegistersuccessAssert.getText().contains("Your registration completed"));

    }

    @Test(dependsOnMethods = "userRegistrationTest")
    public void RegisterUserCanLogOut(){

        registerPage.logoutbtn.click();
    }

    @Test(dependsOnMethods = "RegisterUserCanLogOut")
    public  void RegisterUserCanLogIn(){

        home.openLoginPage();
        loginPage=new LoginPage(driver);
        loginPage.userLogin("omar74@gmail.com","123456");
        Assert.assertTrue(loginPage.loginSuccessAssert.getText().contains("Welcome to our store"));

    }

}
