package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
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

   /* @FindAll({
            @FindBy(css = "div.result"),
            @FindBy(xpath = "//div[@class='result' and contains(text(),'Your registration completed')] ")
    })
   public WebElement RegistersuccessAssert;
*/
    @FindAll({
            @FindBy(linkText = "Log out"),
            @FindBy(xpath = "//a[@class='ico-logout' and contains( text() ,'Log out')]"),
            @FindBy(xpath = "//div[@class='header-links' ]//a[@href='https://demo.nopcommerce.com/' and contains(text(),'Log out')]")
    })

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
