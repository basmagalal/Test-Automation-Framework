package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


// by logic these class will change depends on the website.
public class RegistrationPage extends PageBase {


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gender-male")
    WebElement gendermale;

    @FindBy(id = "FirstName")
    WebElement fname;

    @FindBy(id = "LastName")
     WebElement lname;

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "Password")
    WebElement password ;

    @FindBy(id = "ConfirmPassword")
    WebElement cpassword ;

    @FindBy(id = "register-button")
    WebElement registerbtn ;

    @FindBy(css = "div.result")
   public WebElement RegistersuccessAssert;

    @FindBy(linkText = "Log out")
    public WebElement logoutbtn;

    public void userRegestration(String strFName,String strLName,String strEmail,String strPassword){

        gendermale.click();
        fname.sendKeys(strFName);
        lname.sendKeys(strLName);
        email.sendKeys(strEmail);
        password.sendKeys(strPassword);
        cpassword.sendKeys(strPassword);
        registerbtn.click();


    }



}
