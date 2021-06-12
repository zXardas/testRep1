package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Base{
    public LoginPage(WebDriver driver){super(driver);}

    @FindBy(id ="prependedInput")
    private WebElement inputLogin;

    @FindBy(id ="prependedInput2")
    private WebElement inputPass;

    @FindBy(id ="_submit")
    private WebElement buttonSubmit;

    public LoginPage enterLogin (String login){
        inputLogin.sendKeys(login);
        return this;
    }

    public LoginPage enterPassword (String password){
        inputPass.sendKeys(password);
        return this;
    }

    public HomePage clickLoginButton (){
        buttonSubmit.click();
        return new HomePage(driver);
    }

    public HomePage loginScenario(String login, String pass){
        inputLogin.sendKeys(login);
        inputPass.sendKeys(pass);
        buttonSubmit.click();
        return new HomePage(driver);
    }
}


