package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailWeatherPredictionPage extends Base{

    public MailWeatherPredictionPage (WebDriver driver) {super(driver);}

    @FindBy (xpath= "//input[@name='name']")
    WebElement cityInput;

        public MailWeatherPredictionPage checkWeatherInCity (String city){
            cityInput.sendKeys(city);
            cityInput.sendKeys(Keys.ENTER);
            Assertions.assertTrue(driver.findElement(By.xpath("//h1[@class='information__header__left__place__city'][contains(text(),'"+city.substring(0, city.length()-1)+"')]")).isDisplayed());
            return this;
        }

}
