package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase  {
    public LoginPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(id ="Email" )
    WebElement loginEmailTextBox;

    @FindBy(id ="Password" )
    WebElement loginPassTextBox;
    @FindBy(css="button.button-1.login-button") //tagname.nameof Class without spaces
    WebElement loginbtn;

    @FindBy(css="div.topic-block-title")
      public  WebElement loginSuccessAssert;

    public void userLogin(String email,String pass)
    {
        loginEmailTextBox.sendKeys(email);
        loginPassTextBox.sendKeys(pass);
        loginbtn.click();



    }


}
