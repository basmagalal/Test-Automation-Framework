package tests;

import data.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

import java.io.IOException;

public class RegistrationTest extends TestBase{

    HomePage home;
    RegistrationPage registerPage;

    LoginPage loginPage ;

    @DataProvider(name="Exceldata")

    public Object[][] userData() throws IOException {
        ExcelReader excelReader=new ExcelReader();
        return excelReader.readXSLS();

    }

    @Test(dataProvider = "Exceldata")

    public void userRegistrationTest(String fname,String lname,String email, String pass){

        home=new HomePage(driver);
        home.openRegestrationPage();
        registerPage=new RegistrationPage(driver);
        registerPage.userRegestration(fname,lname,email,pass);
      /*  Assert.assertTrue(registerPage.logoutbtn.isDisplayed());
        registerPage.logoutbtn.click();

        home.openLoginPage();
        loginPage=new LoginPage(driver);
        loginPage.userLogin(email,pass);
        Assert.assertTrue(loginPage.loginSuccessAssert.getText().contains("Welcome to our store"));
       registerPage.logoutbtn.click();*/

    }
    @Test(dataProvider = "Exceldata")
    public void loginTest(String email, String pass){

        Assert.assertTrue(registerPage.logoutbtn.isDisplayed());
        registerPage.logoutbtn.click();

        home.openLoginPage();
        loginPage=new LoginPage(driver);
        loginPage.userLogin(email,pass);
        Assert.assertTrue(loginPage.loginSuccessAssert.getText().contains("Welcome to our store"));
        registerPage.logoutbtn.click();
    }


}
