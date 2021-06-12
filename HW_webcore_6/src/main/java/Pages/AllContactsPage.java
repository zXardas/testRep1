package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllContactsPage extends Base {

    @FindBy(xpath = "//*[@id='container']/div[1]/div/div/div[2]/div/div/a")
    private WebElement createNewContactButton;

    public AllContactsPage(WebDriver driver) {
        super(driver);
    }

    public NewContactPage clickOnCreateNewContactButton() { //проверить тип
        createNewContactButton.click();
        return new NewContactPage(driver);
    }

    public AllContactsPage checkNewContactPopUp() {
        String message = new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='message']"))).getText();
        Assertions.assertTrue(message.contains("Контактное лицо сохранено"));
        return this;
    }
}