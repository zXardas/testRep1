package Pages;

import Navigation.NavigationBar;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class MailHomePage extends Base{

    private NewsBar newsBar;

    @FindBy(name = "clb1283825")
    WebElement buttonWeatherPrediction ;

    public MailWeatherPredictionPage WeatherPredictionButtonClick( WebDriver driver){
        buttonWeatherPrediction.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return new MailWeatherPredictionPage(driver);
    }


    @FindBy(xpath = "//div[@id='mailbox']")
    WebElement divPost ;
    @FindBy(xpath = "//input[@name='login']")
    WebElement loginInput ;
    @FindBy(xpath = "//div[@class='domain-text__wrapper svelte-1eyrl7y']")
    WebElement domainField ;
    @FindBy(xpath = "//select[@name='domain']//option")
    WebElement domainSelects ;
    @FindBy(xpath = "//button[@data-testid='enter-password']")
    WebElement enterPasswordButton ;
    @FindBy(xpath = "//*[@id='mailbox']/form[1]/button[1]")
    WebElement enterPasswordButtonText ;
    @FindBy(xpath = "//label[@data-testid='mail-remember']")
    WebElement checkboxSavePas;
    @FindBy(xpath = "//input[@id='saveauth']")
    WebElement checkboxActive;
    @FindBy(xpath = "//a[@data-testid='mailbox-recovery-link']")
    WebElement buttonRecoveryPass;
    @FindBy(xpath = "//a[@data-testid='mailbox-head-mail']")
    WebElement buttonPost;
    @FindBy(xpath = "//*[@id='mailbox']/div[1]/div/a[1]")
    WebElement buttonCamera;
    @FindBy(xpath = "//*[@id='mailbox']/div[1]/div/a[2]")
    WebElement buttonCloud;
    @FindBy(xpath = "//*[@id='mailbox']/div[1]/div/a[3]")
    WebElement buttonPage;

    public MailHomePage checkAllPostElementsDisplay() {
        Assertions.assertTrue(divPost.isDisplayed());
        Assertions.assertTrue(loginInput.isDisplayed());
        Assertions.assertEquals("Имя ящика", loginInput.getAttribute("placeholder"));
        Assertions.assertTrue(domainField.isDisplayed());
        Assertions.assertTrue(enterPasswordButton.isDisplayed());
        Assertions.assertEquals("Ввести пароль", enterPasswordButtonText.getText());
        Assertions.assertTrue(checkboxSavePas.isDisplayed());
        Assertions.assertEquals("Запомнить", checkboxSavePas.getText());
        Assertions.assertTrue(checkboxActive.isSelected());
        Assertions.assertTrue(buttonRecoveryPass.isDisplayed());
        Assertions.assertEquals("Забыли пароль?", buttonRecoveryPass.getText());
        Assertions.assertTrue(buttonPost.isDisplayed());
        Assertions.assertEquals("Почта", buttonPost.getText());
        Assertions.assertTrue(buttonCamera.isDisplayed());
        Assertions.assertTrue(buttonCloud.isDisplayed());
        Assertions.assertTrue(buttonPage.isDisplayed());




       // Select select = new Select(domainSelects);
       // String values = "@mail.ru"+"\n"+"@inbox.ru"+"\n"+"@list.ru"+"\n"+"@bk.ru"+"\n"+"@internet.ru";
        List<WebElement> allOptions = driver.findElements(By.xpath("//select[@name='domain']/option"));
        Assertions.assertEquals(allOptions.size(),5);
        int i=0;
        for (WebElement options : allOptions) {
            Assertions.assertEquals(options.getText(),MailPostDomain.values()[i++].getName());

        }


        return this;
    }







    public MailHomePage(WebDriver driver) {
        super(driver);
        this.newsBar = new NewsBar(driver);
    }

    public void checkUrl(String url) {
        Assertions.assertEquals(driver.getCurrentUrl(),url);}

    public void checkTitle (String title){
        Assertions.assertEquals(driver.getTitle(),title);
    }

    public NewsBar getNewsBar() {return newsBar;}

}
